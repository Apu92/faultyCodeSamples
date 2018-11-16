# Global constants
BUILD_FOLDER_NAME := build
BUILD_INFER_FOLDER_NAME := $(BUILD_FOLDER_NAME)_infer

BUILD_INFER_DIR = $(shell "pwd")/$(BUILD_INFER_FOLDER_NAME)


export BUILD_DIR = $(shell "pwd")/$(BUILD_FOLDER_NAME)

# Flags passed to the C++ compiler.
export CXXFLAGS = -g -pthread --coverage

# Flags passed to the linker.
export LDFLAGS = -pthread --coverage 


CPPCHECK_INCLUDES = -Isrc
SOURCES_TO_ANALYSE = src


all:
	@mkdir -p $(BUILD_FOLDER_NAME)
	g++ -g -o $(BUILD_DIR)/Main.exe $(SOURCES_TO_ANALYSE)/*.cpp

# ---- RATS -------------------------------------------------------------------
run_RATS:
	@mkdir -p $(BUILD_FOLDER_NAME)
	rats -w 3 --xml $(SOURCES_TO_ANALYSE) > $(BUILD_DIR)/rats-report.xml
	
# ---- Cppcheck ---------------------------------------------------------------
run_cppcheck:
	mkdir -p $(BUILD_FOLDER_NAME)
	cppcheck -v --enable=all --xml $(CPPCHECK_INCLUDES) $(SOURCES_TO_ANALYSE) 2> $(BUILD_DIR)/cppcheck-report.xml
	
# ---- SourceMeter ------------------------------------------------------------	
run_sourcemeter:
	./analyze.sh	
	
prepare_sourcemeter: create_sourcemeter_build create_sourcemeter_analyze

create_sourcemeter_analyze:
	echo "#!/bin/sh\n\n/opt/SourceMeter-8.2.0-x64-linux/CPP/SourceMeterCPP -projectName=simpleNullPointer -buildScript=build.sh -resultsDir=Results -externalSoftFilter=softfilter" > analyze.sh
	chmod +x analyze.sh
	
create_sourcemeter_build:
	echo "#!/bin/sh\n\nmake clean\n\nexport SM_DISABLE_ANALYSIS=true\n./configure\nunset SM_DISABLE_ANALYSIS\n\nmake\n" > build.sh
	chmod +x build.sh

# ---- infer ------------------------------------------------------------------
run_infer:
	infer run -- make build_infer

build_infer:
	@mkdir -p $(BUILD_INFER_FOLDER_NAME)
	g++ -g -o $(BUILD_INFER_DIR)/Main.exe $(SOURCES_TO_ANALYSE)/*.cpp

# ---- SonarQube --------------------------------------------------------------
run_sonarqube:
	sonar-scanner -X

# ---- Clean ------------------------------------------------------------------
clean:
	rm -rf $(BUILD_FOLDER_NAME)
	
clean_all: clean
# Infer
	-rm -rf infer-out
	-rm -rf $(BUILD_INFER_FOLDER_NAME)
# SourceMeter
	-rm -rf Results
	-rm -f build.sh
	-rm -f analyze.sh
	-rm -rf .columbus_cpp
	-rm -rf $(SOURCES_TO_ANALYSE)/.columbus_cpp

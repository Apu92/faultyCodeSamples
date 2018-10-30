export BUILD_DIR = $(shell "pwd")/build

# Flags passed to the C++ compiler.
#export CXXFLAGS = -g -pthread --coverage

# Flags passed to the linker.
#export LDFLAGS = -pthread --coverage


all:
	@mkdir -p build
	cd build; cmake ../ -DCMAKE_CXX_FLAGS=--coverage -DCMAKE_EXE_LINKER_FLAGS=--coverage
	#cd build; cmake ../
	@$(MAKE) -C build

clean:
	rm -r build


test:
	cd build; ctest ../


sonar: sonar_cppcheck sonar_rats sonar_coverage



# Run cppcheck, a general purpose static code checker
sonar_cppcheck:
	cppcheck -v --enable=all --xml include/* src test 2> $(BUILD_DIR)/cppcheck-report.xml

# Run vera: static code checker focusing on code style issues
#sonar_vera:
#	bash -c 'find src -regex ".*\.cc\|.*\.hh" | vera++ - -showrules -nodup |& vera++Report2checkstyleReport.perl > $(BUILD_DIR)/vera++-report.xml'

# Run rats: static code checker focusing on (potential) security problems
sonar_rats:
	rats -w 3 --xml include src test > $(BUILD_DIR)/rats-report.xml

sonar_coverage:
	gcovr -x -r . > $(BUILD_DIR)/gcovr-report.xml

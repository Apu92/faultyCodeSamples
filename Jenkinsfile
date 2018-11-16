node {
    //
    // Constants
    //
	def SOURCE_FOLDER = "src"
	
	def BUILD_FOLDER_CPP = "build"
	def BUILD_FOLDER_CPP_INFER = BUILD_FOLDER_CPP + "_infer"

	def DIR_LANGUAGE_CPP = "C++/"
	def DIR_LANGUAGE_JAVA = "Java/"
	def SUPPORTED_LANGUAGES = [ DIR_LANGUAGE_CPP, DIR_LANGUAGE_JAVA ]
	
	def RATS_REPORT_FILE = "${BUILD_FOLDER_CPP}/rats-report.xml"
	def CPPCHECK_REPORT_FILE = "${BUILD_FOLDER_CPP}/cppcheck-report.xml"
	def INFER_REPORT_FILE = "infer-out/report.xml"
	
	def REPORT_FILES = [ "grep -o '<vulnerability>' ${RATS_REPORT_FILE} | wc -l",
						 "grep -o '<error id' ${CPPCHECK_REPORT_FILE} | wc -l", 
						 "grep -o '<violation' ${INFER_REPORT_FILE} | wc -l" ]
	
	def TOOLS = [ RATS : "-Dsonar.cxx.rats.reportPath=${RATS_REPORT_FILE}", 
				  Cppcheck : "-Dsonar.cxx.cppcheck.reportPath=${CPPCHECK_REPORT_FILE}" ]
	
	//
	// Variables
    //
	def directorities = [:]
	
	def mvnHome
	def sonarScannerHome
	
	//
	// Stages
	//
	stage ('Define Tools') {
	    mvnHome = tool 'M3'
      	sonarScannerHome = tool name: 'SonarScanner'
	}
    stage('Delete WS & Clone') {
    	deleteDir()
        // Get some code from a GitHub repository
        git 'https://github.com/Apu92/faultyCodeSamples.git'
    }
    stage('Determine Projects') {
		def dirLanguages = getSubfolders("${WORKSPACE}")
		
		for (directory in dirLanguages) {
			def dirProjects = getSubfolders("${WORKSPACE}/" + directory)
			directorities[directory] = dirProjects 
		}
		echo "${directorities}"
    }
    stage ('Run RATS') {
		runTool(directorities, DIR_LANGUAGE_CPP, "mkdir -p ${BUILD_FOLDER_CPP}", "rats -w 3 --xml ${SOURCE_FOLDER} > ${RATS_REPORT_FILE}")
    }
    stage ('Run Cppcheck') {
		runTool(directorities, DIR_LANGUAGE_CPP, "mkdir -p ${BUILD_FOLDER_CPP}", "cppcheck -v --enable=all --xml ${SOURCE_FOLDER} 2> ${CPPCHECK_REPORT_FILE}")
    }
    stage ('Run infer') {
		runTool(directorities, DIR_LANGUAGE_CPP, "mkdir -p ${BUILD_FOLDER_CPP_INFER}", "infer run --pmd-xml -- g++ -std=c++11 -g -o ${BUILD_FOLDER_CPP_INFER}/Main.exe ${SOURCE_FOLDER}/*.cpp")
    }
    stage('Results') {
		for (project in directorities[DIR_LANGUAGE_CPP]) {
			dir (DIR_LANGUAGE_CPP + project) {
				for (reportFile in REPORT_FILES) {
					echo reportFile
					sh "${reportFile}"		                 
                }
			}
		}
    }
    stage ('SonarQube Solo') {
		def toolNames = TOOLS.keySet()
		echo "toolNames: ${toolNames}"
		
		for (tool in toolNames) {				
			def properties = TOOLS[tool]
			runSonarQubeForLanguageProjects(directorities, DIR_LANGUAGE_CPP,
				"SonarQube solo", sonarScannerHome, tool, properties)
		}
    }
    stage ('SonarQube SourceMeter') {
		def properties = "-Dsm.cpp.buildfile=build.sh -Dsonar.language=cpp"
    	runSonarQubeForLanguageProjects(directorities, DIR_LANGUAGE_CPP, 
    		"SonarQube SourceMeter", sonarScannerHome, "SourceMeter", properties)
    }
}

def runSonarQubeForLanguageProjects(directorities, language, instanceName, sonarScannerHome, toolName, properties) {
	for (project in directorities[language]) {
		dir (language + project) {			
			def projectKey = language + project + toolName
			projectKey = projectKey.replaceAll("/", "_")
			
			def projectName = projectKey
			projectKey = projectKey.replaceAll("C\\+\\+", "Cpp")
			
			withSonarQubeEnv("${instanceName}") {
		    	sh "time ${sonarScannerHome}/bin/sonar-scanner \
		        	-Dsonar.projectKey=${projectKey} \
		            -Dsonar.projectName=${projectName} \
		            -Dsonar.projectVersion=1.0 \
		            -Dsonar.sources=src ${properties}"
		    }
		}
	}  
}

def runTool(directorities, DIR_LANGUAGE, precommand, command) {
  	for (project in directorities[DIR_LANGUAGE]) {
   		if (project.contains("@")) {
			continue       
		}
		
    	dir (DIR_LANGUAGE + project) {
    		if (precommand != null && !precommand.isEmpty()) {
				sh "${precommand}"
    		}
			 
			sh "${command}"                        
        }
	}  
}

def getSubfolders(directory)
{
    dir(directory) {
	    def subfolders = sh(returnStdout: true, script: "ls -d */").trim().tokenize("\n")   
	    subfolders
    }
}

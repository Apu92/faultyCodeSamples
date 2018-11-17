node {
    //
    // Constants
    //
	def SOURCE_FOLDER = "src"
	
	def BUILD_FOLDER_CPP = "build"
	def BUILD_FOLDER_CPP_INFER = BUILD_FOLDER_CPP + "_infer"

	def DIR_LANGUAGE_CPP = "C++/"
	def DIR_LANGUAGE_JAVA = "Java/"
	
	def DIR_PROJECT_GROUP_SIMPLE = "simple/"
	
	def DIR_CPP_SIMPLE_PROJECTS = DIR_LANGUAGE_CPP + DIR_PROJECT_GROUP_SIMPLE
	def DIR_JAVA_SIMPLE_PROJECTS = DIR_LANGUAGE_JAVA + DIR_PROJECT_GROUP_SIMPLE
	
	def RATS_REPORT_FILE = "${BUILD_FOLDER_CPP}/rats-report.xml"
	def CPPCHECK_REPORT_FILE = "${BUILD_FOLDER_CPP}/cppcheck-report.xml"
	def INFER_REPORT_FILE = "infer-out/report.xml"
	
	def REPORT_FILES = [ "grep -o '<vulnerability>' ${RATS_REPORT_FILE} | wc -l",
						 "grep -o '<error id' ${CPPCHECK_REPORT_FILE} | wc -l", 
						 "grep -o '<violation' ${INFER_REPORT_FILE} | wc -l" ]
	
	def TOOLS_CPP = [ RATS : "-Dsonar.cxx.rats.reportPath=${RATS_REPORT_FILE}", 
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
		
		for (dirLanguage in dirLanguages) {
			def dirProjectGroups = getSubfolders("${WORKSPACE}/" + dirLanguage)
			
			for (dirProjectGroup in dirProjectGroups) {
			    def dirProjects = getSubfolders("${WORKSPACE}/" + dirLanguage + dirProjectGroup)
			    directorities[dirLanguage+dirProjectGroup] = dirProjects
			}
		}
		echo "${directorities}"
    }
    stage ('Run RATS') {
		runTool(directorities, DIR_CPP_SIMPLE_PROJECTS, "mkdir -p ${BUILD_FOLDER_CPP}", "rats -w 3 --xml ${SOURCE_FOLDER} > ${RATS_REPORT_FILE}")
    }
    stage ('Run Cppcheck') {
		runTool(directorities, DIR_CPP_SIMPLE_PROJECTS, "mkdir -p ${BUILD_FOLDER_CPP}", "cppcheck -v --enable=all --xml ${SOURCE_FOLDER} 2> ${CPPCHECK_REPORT_FILE}")
    }
    stage ('Run infer C++') {
		runTool(directorities, DIR_CPP_SIMPLE_PROJECTS, "mkdir -p ${BUILD_FOLDER_CPP_INFER}", "infer run --pmd-xml -- g++ -std=c++11 -g -o ${BUILD_FOLDER_CPP_INFER}/Main.exe ${SOURCE_FOLDER}/*.cpp")
    }
    stage ('Run infer Java') {
		runTool(directorities, DIR_JAVA_SIMPLE_PROJECTS, "infer run --pmd-xml -- mvn package")
    }
//    stage('Results') {
//		for (project in directorities[DIR_CPP_SIMPLE_PROJECTS]) {
//			dir (DIR_CPP_SIMPLE_PROJECTS + project) {
//				for (reportFile in REPORT_FILES) {
//					echo reportFile
//					sh "${reportFile}"		                 
//                }
//			}
//		}
//    }
    stage ('SonarQube Solo C++') {
		def toolNames = TOOLS_CPP.keySet()
		echo "toolNames: ${toolNames}"
		
		for (tool in toolNames) {				
			def properties = TOOLS_CPP[tool]
			runSonarQubeForCppProjects(directorities, DIR_CPP_SIMPLE_PROJECTS,
				"SonarQube solo", sonarScannerHome, tool, properties)
		}
    }
    stage ('SonarQube SourceMeter C++') {
		def properties = "-Dsm.cpp.buildfile=build.sh -Dsonar.language=cpp"
    	runSonarQubeForCppProjects(directorities, DIR_CPP_SIMPLE_PROJECTS, 
    		"SonarQube SourceMeter", sonarScannerHome, "SourceMeter", properties)
    }
	stage ('SonarQube Solo Java') {
	    runSonarQubeForJavaProjects(directorities, DIR_JAVA_SIMPLE_PROJECTS, 
	    	"SonarQube solo", "SonarQube")                       
	}
	stage ('SonarQube SourceMeter Java') {
	    runSonarQubeForJavaProjects(directorities, DIR_JAVA_SIMPLE_PROJECTS, 
	    	"SonarQube SourceMeter", "SourceMeter")                       
	}
	stage ('SonarQube FindBugs Java') {
	    runSonarQubeForJavaProjects(directorities, DIR_JAVA_SIMPLE_PROJECTS, 
	    	"SonarQube FindBugs", "FindBugs")                       
	}
	stage ('SonarQube PMD Java') {
	    runSonarQubeForJavaProjects(directorities, DIR_JAVA_SIMPLE_PROJECTS, 
	    	"SonarQube PMD", "PMD")                       
	}
}

def runSonarQubeForJavaProjects(directorities, directory, instanceName, toolName) {
	runSonarQubeForLanguageProjects(directorities, directory, instanceName, "mvn package sonar:sonar -Dmaven.test.failure.ignore=true", toolName, "")                                                                                                       
}

def runSonarQubeForCppProjects(directorities, directory, instanceName, sonarScannerHome, toolName, properties) {
	runSonarQubeForLanguageProjects(directorities, directory, instanceName, "${sonarScannerHome}/bin/sonar-scanner", toolName, properties)                                                                                                       
}

def runSonarQubeForLanguageProjects(directorities, directory, instanceName, sonarCommand, toolName, properties) {
	for (project in directorities[directory]) {
		dir (directory + project) {			
			def projectKey = directory + project + toolName
			projectKey = projectKey.replaceAll("/", "_")
			
			def projectName = projectKey
			projectKey = projectKey.replaceAll("C\\+\\+", "Cpp")
			
			withSonarQubeEnv("${instanceName}") {
		    	sh "time ${sonarCommand} \
		        	-Dsonar.projectKey=${projectKey} \
		            -Dsonar.projectName=${projectName} \
		            -Dsonar.projectVersion=1.0 \
		            -Dsonar.sources=src ${properties}"
		    }
		}
	}  
}

def runTool(directorities, directory, command) {
	runTool(directorities, directory, "", command)                                   
}

def runTool(directorities, directory, precommand, command) {
  	for (project in directorities[directory]) {
    	dir (directory + project) {
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

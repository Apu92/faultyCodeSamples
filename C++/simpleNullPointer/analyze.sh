#!/bin/sh

/opt/sonarqube-6.7.5/extensions/plugins/SourceMeter-8.2.0-x64-linux/CPP/SourceMeterCPP -projectName=simpleNullPointer -buildScript=build.sh -resultsDir=Results -externalSoftFilter=softfilter

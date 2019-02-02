#!/usr/bin/env groovy

pipeline {
  agent any

  environment {
    AUTH = credentials('password')
  }

  stages {

    stage('Start Release') {
      steps {
        script {
          try {
            if ("${params.BRANCH}" == 'develop') {
              timeout(time: 1, unit: 'MINUTES') {

                def startReleaseInput = input(
                        id: 'Start', message: 'Do you want to start the release process?', parameters: [
                        [$class: 'BooleanParameterDefinition', defaultValue: false, description: '', name: 'Release!'],
                        [$class: 'TextParameterDefinition', defaultValue: 'develop-SNAPSHOT', description: '', name: 'DEV'],
                        [$class: 'TextParameterDefinition', defaultValue: '1.1', description: '', name: 'REL']
                ]
                )

                if (startReleaseInput['Release!'] == true) {

                  def DEVELOP_VERSION = startReleaseInput['DEV']
                  def RELEASE_VERSION = startReleaseInput['REL']

                  sh 'git branch'
                  sh 'git checkout develop'
                  sh 'git pull'
                  executeMavenCommand "mvn -e jgitflow:release-start -DdevelopmentVersion=$DEVELOP_VERSION - DreleaseVersion=$RELEASE_VERSION"

                }
              }
            }
          } catch (Exception e) {
            echo 'No Release Process started.'
          }
        }
      }
    }

    stage('Finish Release') {
      steps {
        script {
          try {
            def branchName = "${params.BRANCH}"
            if (branchName.contains('release')) {
              timeout(time: 1, unit: 'MINUTES') {

                def finishReleaseInput = input(
                        id: 'Start', message: 'Do you want to finish the release process?', parameters: [
                        [$class: 'BooleanParameterDefinition', defaultValue: false, description: '', name: 'Finish!'],
                        [$class: 'TextParameterDefinition', defaultValue: '1.1', description: '', name: 'REL']
                ]
                )

                if (finishReleaseInput['Release!'] == true) {

                  executeMavenCommand("mvn -e jgitflow:release-finish")

                }

              }
            }
          } catch (Exception e) {
            echo 'No Release Process finished.'
          }
        }
      }
    }

  }
}

def executeMavenCommand(mavenCommand) {
    withMaven() {
        sh "${mavenCommand}"
    }
}
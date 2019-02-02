#!/usr/bin/env groovy

pipeline {
  agent any

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

                  sshagent (credentials: ['77d04bc5-89fa-4884-b4e9-de9b17384915']) {
                    sh 'git remote set-url origin git@github.com:Schmowser/RadioRepetitive'
                    sh 'git push -f origin HEAD:develop'
                    executeMavenCommand "mvn -e jgitflow:release-start -DdevelopmentVersion=$DEVELOP_VERSION - DreleaseVersion=$RELEASE_VERSION"
                  }
                }

              }
            }
          } catch (Exception e) {
            echo 'No Release Process started.'
          }
        }
      }
    }

    stage('Build') {
      steps {
        executeMavenCommand('mvn -B -V -U -e clean verify')
      }
    }

    stage('Finish Release') {
      when {
        anyOf {
          branch '**/release/*'
        }
      }
      steps {
        script {
          try {
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
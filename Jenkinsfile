#!/usr/bin/env groovy

pipeline {
  agent any

  stages {

    stage('Build') {
      steps {
        executeMavenCommand('mvn -B -V -U -e clean verify')
      }
    }

    stage('Print') {
      steps {
        echo 'Checked out master!'
      }
    }

  }
}

def executeMavenCommand(mavenCommand) {
#    withMaven(jdk: 'jdk8', maven: 'apache-maven-3.3.9') {
        sh "${mavenCommand}"
#    }
}
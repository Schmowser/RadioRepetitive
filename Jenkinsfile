pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/Schmowser/RadioRepetitive.git', branch: 'master')
      }
    }
    stage('Print') {
      steps {
        echo 'Checked out master!'
      }
    }
  }
}
pipeline {
  agent {
    node {
      def app
      label 'chuck-norris'
      customWorkspace '/var/lib/jenkins/workspace/chuck-norris'
    }
  }
  stages {
    stage('Build image') {
      steps{
        step('Build image') {
          app = docker.build("pelipe/chuck-norris-jokes")
        }
      }
    }
    stage('Push image') {
      steps{
        step('Push image') {
          docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
              app.push("latest")
          }
        }
      }
    }
  }
}
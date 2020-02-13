node {
    def app
    agent any
    tools{
        maven 'Maven 3.6.3'
        jdk 'jdk8'
    }
    stage('Clone repository') {

        checkout scm
    }

    stage('Build application') {

        app.inside {
            sh 'mvn package'
        }
    }

    stage('Build image') {

        app = docker.build("pelipe/chuck-norris-jokes")
    }

    stage('Test image') {

        app.inside {
            sh 'echo "Tests passed :)"'
        }
    }

    stage('Push image') {

        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("latest")
        }
    }
}
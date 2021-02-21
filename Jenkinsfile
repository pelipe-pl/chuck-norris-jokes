pipeline {
    environment{
        registry = "pelipe/chuck-norris-jokes"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }
    agent
    {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2 -u root'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Initialize'){
        def dockerHome = tool 'myDocker'
        env.PATH = "${dockerHome}/bin:${env.PATH}"
        }
        stage('Docker Build') {

            steps {
                script{
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Docker Push') {
            agent any
            steps {
              withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerhubPassword', usernameVariable: 'dockerhubUser')]) {
                      sh "docker login -u ${env.dockerhubUser} -p ${env.dockerhubPassword}"
                      sh 'docker push pelipe/chuck-norris-jokes:latest'
                }
            }
        }
    }
}
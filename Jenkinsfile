pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
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
        stage('Dokcer Build') {
            steps {
                sh 'docker build -t pelipe/chuck-norris-jokes .'
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
pipeline {
    agent any
    tools {
        maven 'Maven 3.9.6'
        jdk 'JDK 17.0.11'
    }
    stages {
        stage('Checkout'){
            steps{
                checkout scm
            }
        }
        stage('Clean images not used'){
            steps{
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "make clean"
                }
            }
        }
        stage('Running Test') {
                    steps {
                        sh "make test"
                    }
                }
        stage('Build Image') {
            steps {
                sh "make local"
            }
        }
        stage('Run Container'){
            steps {
                sh "make run"
            }
        }
    }
}
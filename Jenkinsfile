pipeline {
    agent any
    tools {
        maven 'M2'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Clean images not used') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh 'make clean'
                }
            }
        }
        stage('Running Test') {
                    steps {
                        sh 'make test'
                    }
        }
        stage('Build Image') {
            steps {
                sh 'make local'
            }
        }
        stage('Run Container') {
            steps {
                sh 'make run'
            }
        }
    }
    post {
        success {
            jacoco(
            execPattern: '**/build/jacoco/*.exec',
            classPattern: '**/build/classes/java/main',
            sourcePattern: '**/src/main'
            )
        }
    }
}

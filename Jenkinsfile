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
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'make sonar'
                }
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
            execPattern: '**/target/*.exec',
            classPattern: '**/target/classes',
            sourcePattern: '**/src/main'
            )
        }
        failure {
            echo 'Failed'
            slackSend channel: 'despliegues', color: 'danger', iconEmoji: 'pokeball', message: "La ejecucion ${env.JOB_NAME} ha fallado, # ${env.BUILD_NUMBER} ${env.BUILD_URL}", tokenCredentialId: 'slack'
        }
        fixed {
            echo 'Fixed'
            slackSend channel: 'despliegues', color: 'good', iconEmoji: 'pokeball', message: "La ejecucion ${env.JOB_NAME} ha sido corregida, # ${env.BUILD_NUMBER} ${env.BUILD_URL}", tokenCredentialId: 'slack'
        }

    }
}

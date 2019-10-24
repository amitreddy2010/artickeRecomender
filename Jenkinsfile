pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven(maven: 'maven_3_3_9') {
                	sh 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
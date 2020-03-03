pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
            	sh 'cf login -a https://api.run.pivotal.io -u sureshkumark@dbs.com -p Waverock@1234 -o recommender -s development'
            	sh 'cf push'
                echo 'Deploying....'
            }
        }
    }
}
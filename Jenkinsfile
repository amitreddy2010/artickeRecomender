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
            	sh 'cf login -a https://api.run.pivotal.io -u amitkarkala@dbs.com -p Amit#2013 -o articleRecommender -s development'
            	sh 'cf push'
                echo 'Deploying....'
            }
        }
    }
}
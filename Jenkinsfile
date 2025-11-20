pipeline {
    agent any
    tools{
        maven 'Default'

    }

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21' // Adjust to your actual JDK pat
        SONARQUBE_SERVER = 'SonarQubeServer' // The name of the SonarQube server configured in Jenkins
        SONAR_TOKEN = 'sqa_dec28b242507fd7dfcfb11e5be8c6a38e0ecfcf9' // Store the token securely

        PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"

        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        DOCKER_IMAGE = 'viridescentful/codeanalysis'
        DOCKER_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Viridescentful/Week4Lecture.git'
            }
        }

        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn test'
                    } else {
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Build') {
                    steps {
                        script {
                            if (isUnix()) {
                                sh 'mvn clean package'
                            } else {
                                bat 'mvn clean package'
                            }
                        }
                    }
                }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    bat """
                        ${tool 'SonarScanner'}\\bin\\sonar-scanner ^
                        -Dsonar.projectKey=devops-demo ^
                        -Dsonar.sources=src ^
                        -Dsonar.projectName=DevOps-Demo ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=${env.SONAR_TOKEN} ^
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }
    }

  post {
    always {
        junit(testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true)
        jacoco(execPattern: '**/target/jacoco.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java', inclusionPattern: '**/*.class', exclusionPattern: '')
    }
}


}


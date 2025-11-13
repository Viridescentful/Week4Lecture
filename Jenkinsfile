pipeline {
    agent any
    tools{
        maven 'Default'

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

    }

  post {
    always {
        junit(testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true)
        jacoco(execPattern: '**/target/jacoco.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java', inclusionPattern: '**/*.class', exclusionPattern: '')
    }
}


}


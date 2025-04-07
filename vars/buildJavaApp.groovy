def call() {
    pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }
            stage('Build with Maven') {
                steps {
                    sh 'mvn clean install -DskipTests'
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }
        }
    }
}

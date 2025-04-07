def call() {
    stage('Checkout') {
        checkout([
          $class: 'GitSCM',
          branches: [[name: '*/main']],
          userRemoteConfigs: [[url: 'https://github.com/your-org/your-java-app.git']]
        ])
    }

    stage('Debug Workspace') {
        sh 'pwd'
        sh 'ls -la'
    }

    stage('Build with Maven') {
        sh 'mvn clean install -DskipTests'
    }

    stage('Test') {
        sh 'mvn test'
    }
}

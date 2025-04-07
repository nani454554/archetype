def call(String imageName) {
    stage('Docker Build') {
        sh "docker build -t ${imageName} ."
    }

    stage('Docker Push') {
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            sh """
                echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                docker push ${imageName}
            """
        }
    }
}

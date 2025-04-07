def call(String imageName) {
    stage('Docker Build') {
         withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            sh """
                echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
        sh "docker build -t ${imageName} ."
    }

    stage('Docker Push') {
       
                docker push ${imageName}
            """
        }
    }
}

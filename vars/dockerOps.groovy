// def call(String imageName) {
//     stage('Docker Build') {
//          withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
//             sh """
//                 echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
//         sh "docker build -t ${imageName} ."
//     }

//     stage('Docker Push') {
       
//                 docker push ${imageName}
//             """
//         }
//     }
// }
def call(String imageName) {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker build -t ${imageName} .
            docker push ${imageName}
        """
    }
}

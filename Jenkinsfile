@Library('jenkins-shared-library') _
import org.company.utils.GitUtils

pipeline {
    agent any

    environment {
        IMAGE = "nani4545/myapp:${env.BUILD_NUMBER}"
    }

    stages {
        stage('Build Java App') {
            steps {
                buildJavaApp()
            }
        }

        stage('Docker Ops') {
            steps {
                dockerOps("${IMAGE}")
            }
        }

        stage('Git Info') {
            steps {
                script {
                    def git = new GitUtils(this)
                    def shortHash = git.shortCommitHash()
                    echo "Short Git Commit Hash: ${shortHash}"
                }
            }
        }
    }
}

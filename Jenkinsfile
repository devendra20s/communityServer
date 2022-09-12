pipeline {
    agent any
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'git@github.com:code09-web/communityServer.git',credentialsId: '42ca7b4d-8e23-43fb-804e-f8d150a49406']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t communityServer/community_server .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubPwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u devendra09 -p ${dockerhubpwd}'
}
                   sh 'docker push communityServer/community_erver'
                }
            }
        }

    }
}
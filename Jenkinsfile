pipeline{
    agent any
    stages{
        stage('Git checkout'){
            steps{
                echo 'git checkout done'
            }
        }
        stage('Maven build'){
            steps{
                script{
                    sh 'mvn clean package'
                }
            }
        }
    }
}

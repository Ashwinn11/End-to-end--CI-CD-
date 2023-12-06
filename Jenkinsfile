@Library('my_lib') _
pipeline{
    agent any
    parameters{
        choice(name:'action',choices:'create\ndelete',description:'Choose Create/Destroy')
        string(name:'ImageName',description: 'Name of the image',defaultValue:'web-app')
        string(name:'ImageVersion',description: 'Version of the image',defaultValue:'v1')
        string(name:'UserName',description: 'Username of the hub',defaultValue:'docker')
    }
    stages{
        stage('git checkout'){
            when { expression { params.action == 'create' } }
            steps{
                sh 'echo passed'
            }
        }
        stage('Unit test using shared lib'){
            when { expression { params.action == 'create' } }
            steps{
                mvnTest()
            }
        }
        stage('Integration test using shared lib'){
            when { expression { params.action == 'create' } }
            steps{
                mvnIntegrationTest()
            }
        }
        stage('Static code analysis'){
            when { expression { params.action == 'create' } }
            steps{
                def credentials = 'sonarqube_api'
                staticCodeAnalysis(credentials)
            }

        }
        stage('Quality gate check'){
            when { expression { params.action == 'create' } }
            steps{
                def credentials = 'sonarqube_api'
                QualityGateStatus(credentials)
            }

        }
        stage('Maven build'){
            when { expression { params.action == 'create' } }
            steps{
                mvnBuild()
            }
        }
        stage('Docker build'){
            when { expression { params.action == 'create' } }
            steps{
                dockerBuild("${params.ImageName}","${params.ImageTag}","${params.UserName}")
            }
        }



    }
}
@Library('my_lib') _
pipeline{
    agent any
    parameters{
        choice(name:'action',choices:'create\ndelete',description:'Choose Create/Destroy')
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


    }
}
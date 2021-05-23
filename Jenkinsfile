pipeline{
    agent any
        stages {
            
            stage('Build'){
                
                steps{
                    echo "Building"
                }

            }
           
  
           stage('Test'){
                
                steps{
                   catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
          //for windows ---> use bat :  bat "mvn clean install"                                                
                    sh "mvn clean install"
                   }

                }

            }
            
            stage('Publish Allure Reports'){
                
                steps{
                    script{
                        
                        allure([
                                 includeProperties : false,
                                 jad: '',
                                 properties: [ ],
                                 reportBuildPolicy: 'ALWAYS',
                                 results: [[path: '/allure-results' ]]
                                                     
                          ])
                    }

                
                }

            }
            
            stage('Publish Exten Report'){
                
                steps{
                    publishHTML([allowMissing: false,
                                 alwaysLinkToLastBuild : false,
                                 keepAll : false,
                                 reportDir: 'build',
                                 reportFiles: 'TestExecutionReport.html',
                                 reportName: 'HTML Extent Report',
                                 reportTitles: '' ])
                }

            }
           
       

        }

    
}

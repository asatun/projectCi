pipeline {
    agent any
        stages{

            stage('Maven and sonar'){
            
            parallel{
            stage('Sonar Analysis'){
                steps{
                    withSonarQubeEnv('sonar') {
                        bat 'mvn sonar:sonar'
                    }
                }
            }
            
             stage('Mvn Build'){
                steps{
                    bat 'mvn clean package -DskipTests'
                }
            }
             
        }  
                //end parallel stages
                
                //start  uploading nexus
                
                   
        }
        }
}

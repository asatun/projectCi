pipeline {
    agent any
        stages{

            stage('Maven and Sonar'){
            
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
                    bat 'mvn clean package'
                }
            }
     
        }   
        }
        }
}

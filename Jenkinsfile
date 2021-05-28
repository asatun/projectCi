pipeline {
    agent any
        stages{

            stage('Maven and sonar'){
            
            parallel{
            stage('Sonar Analysis'){
                steps{
                    withSonarQubeEnv('Sonar') {
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
        }
        }
}

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
                
               
                
                   
        }
             //start  uploading nexus
               stage('uploading to nexus'){
                 steps{
                     nexusArtifactUploader artifacts: [
                        [artifactId: 'Timesheet-spring-boot-core-data-jpa-mvc-REST-1',
                        classifier: '', 
                        file: 'target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war', 
                        type: 'war']], credentialsId: 'nexus', groupId: 'tn.esprit.spring', 
                        nexusUrl: 'localhost:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'maven-releases/', 
                        version: '1.0'
                 }
             }
        }
}

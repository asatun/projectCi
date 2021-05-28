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
                    bat 'mvn clean package -DskipTests'
                }
            }
                
                
     
        } 
                
                  stage('uploading to nexus'){
                 steps{
                     nexusArtifactUploader artifacts: [
                        [artifactId: 'Timesheet-spring-boot-core-data-jpa-mvc-REST-1',
                        classifier: '', 
                        file: 'target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1-SNAPSHOT.war', 
                        type: 'war']], credentialsId: 'nexus3', groupId: 'tn.esprit.spring', 
                        nexusUrl: 'localhost:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'maven-releases/', 
                        version: '1.0'
                 }
             }
        }
        }
}

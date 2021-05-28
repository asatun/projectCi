pipeline {
    agent any
        stages{

            stage('Maven and Sonar'){
            
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
                    bat 'mvn clean package'
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
                        repository: 'Timesheet/', 
                        version: '0.0.1-SNAPSHOT'
                 }
             }
             stage('Email Notifications'){
                 steps{
                 mail bcc: '', body: '''Hello , 

                A Build has been executed on Your Project Timesheet , if you notice any bugs or abnormal behaviour please contact your team leader

                Best Regards , 
                Bouhmid''', 
                cc: '', from: '', replyTo: '', subject: 'A Build was executed on timesheet', to: 'karouii.ahmed@gmail.com'
             
                 }
                 }
        }   
        }
        }
}

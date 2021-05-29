pipeline {
    agent any
        stages{

            stage('Build et test Statique Sonar'){
            
            parallel{
            stage('test Statique Sonar'){
                steps{
                    withSonarQubeEnv('sonar') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
            
             stage('Maven -Build'){
                steps{
                    sh 'mvn clean package -DskipTests'
                }
            }
             
        }  
                //end parallel stages
                
               
                
                   
        }
             //start  uploading nexus
               stage('Telechargement vers Nexus'){
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

        post {

            success {
                         // Email notification success build 
            
              
                 mail bcc: '', body: '''Bonjour , 
                etat de dernier buils : SUCCESS !!
                Bonne journée , 
                --Arfaoui Ahmed''', 
                cc: '', from: 'ahmed.8.ca@gmail.com', replyTo: '', subject: 'Resultat de dernier Pipe line', to: 'ahmed.8.ca@gmail.com'
             
                
                 }

           

                  failure {
                         // Email notification success build 
            
                
                 mail bcc: '', body: '''Bonjour , 
                etat de dernier buils : FAILURE !!
                Bonne journée , 
                --Arfaoui Ahmed''', 
                cc: '', from: 'ahmed.8.ca@gmail.com', replyTo: '', subject: 'Resultat de dernier Pipe line', to: 'ahmed.8.ca@gmail.com'
             
              
            }
        }

         
}

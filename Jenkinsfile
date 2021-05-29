pipeline {
    agent any
    parameters {
        string (name : 'BRANCH' , description : 'Quelle branche voulez-vous déployer ?')
        string (name : 'VERSION' , description : 'Version de lArtifact')
        booleanParam(name : 'executerTest', defaultValue:false, description : 'voulez-vous executer les tests ? ')
    }
        stages{

            stage('Test statique  : Sonar'){
            
          
           
                steps{
                    withSonarQubeEnv('sonar') {
                        sh 'mvn sonar:sonar'
                    }
                }
                        
                                 
        }

              stage('Maven -Build'){
                  when {
                      expression {
                          params.executerTest
                      }

                  }

                steps{
                    echo 'Build et Execution des tests unitaires encours ...'
                    sh 'mvn clean package '
                }
            }


             //start  uploading nexus
               stage('Deploiement sur  Nexus'){
                 steps{
                     echo "deploiement de la version  {params.$VERSION} "
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
                etat de dernier build : SUCCESS !!
                Bonne journee , 
                --Arfaoui Ahmed''', 
                cc: '', from: 'ahmed.8.ca@gmail.com', replyTo: '', subject: 'Resultat de dernier Pipe line', to: 'ahmed.8.ca@gmail.com'
             
                
               

            }

                  failure {
                         // Email notification success build 
           
                 
                 mail bcc: '', body: '''Bonjour , 
                etat de dernier build : FAILURE !!
                Bonne journee , 
                --Arfaoui Ahmed''', 
                cc: '', from: 'ahmed.8.ca@gmail.com', replyTo: '', subject: 'Resultat de dernier Pipe line', to: 'ahmed.8.ca@gmail.com'
             
               
                

            }
        }

         
}

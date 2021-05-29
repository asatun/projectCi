pipeline {
    agent any
    parameters {
        string (name : 'BRANCH' , description : 'Quelle branche voulez-vous déployer ?')
        string (name : 'VERSION' , description : 'Version de lArtifact')
        booleanParam(name : 'executerTest', defaultValue:true, description : 'voulez-vous executer les tests ? ')
    }
        stages{

            stage('Test statique  : Sonar'){
            
          
           
                steps{
                    withSonarQubeEnv('sonar') {
                        sh 'mvn sonar:sonar'
                    }
                }
                        
                                 
        }
            
            //build 

              stage('Maven -Build'){
                  steps {
                  
                      script {
                          if (params.executerTest == true) {
                        echo 'Build et Execution des tests unitaires encours ...'
                           sh 'mvn clean package '
                    } else {
                        echo 'Build   (sans !!)  Execution des tests unitaires encours ...'
                           sh 'mvn clean package -DskipTests'
                    }
                      
                      }
                  }
                 
           
            }

              // end build 
             //start  uploading nexus
               stage('Deploiement sur  Nexus'){
                 steps{
                     echo "deploiement de la version  {params.$VERSION} "
                     nexusArtifactUploader artifacts: [
                        [artifactId: 'Timesheet-spring-boot-core-data-jpa-mvc-REST-1',
                        classifier: '', 
                        file: 'target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-${VERSION}.war', 
                        type: 'war']], credentialsId: 'nexus', groupId: 'tn.esprit.spring', 
                        nexusUrl: 'localhost:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'maven-releases/', 
                         version: ${VERSION}
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

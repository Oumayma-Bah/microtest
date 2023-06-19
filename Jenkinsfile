pipeline {
    agent any
    stages {
        stage('GIT') {
                    steps {
                        echo "getting project from git"
                        withCredentials([usernamePassword(credentialsId: 'git-cred', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
                            git branch: 'main', credentialsId: 'git-cred', url: 'https://github.com/Oumayma-Bah/microtest.git'
                        }
                    }
        }
        stage('MVN CLEAN') {
                    steps {
                        sh 'mvn -e clean'
                    }
        }
        stage('MVN COMPILE') {
                    steps {
                        sh 'mvn compile'
                    }
        }
        stage('MVN SONARQUBE') {
            steps {
               script {
                  withCredentials([usernamePassword(credentialsId: '4b2d9ca2-2d87-41be-b9ec-7681caea0426', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                      withSonarQubeEnv('SonarQube') {
                        //env.MAVEN_OPTS = "-Duser.home=${env.WORKSPACE}/.m2 -Dmaven.repo.local=${env.WORKSPACE}/.m2/repository"
                        //sh "cd avec-maven && mvn sonar:sonar -Dsonar.login=$USERNAME -Dsonar.password=$PASSWORD"
                        sh "mvn sonar:sonar -Dsonar.login=\$USERNAME -Dsonar.password=\$PASSWORD"
                        }

                    }
                }
            }
        }
        stage('JUnit / Mockito') {
            steps {
              sh 'mvn test'
              junit 'target/surefire-reports/*.xml'
            }
        }
        stage('Nexus') {
                            steps {
  sh 'mvn clean package deploy:deploy-file -DgroupId=com.microservice -DartifactId=task -Dversion=0.0.1-SNAPSHOT -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo  -Durl=http://172.10.0.140:8081/repository/maven-snapshots/ -Dfile=target/task-0.0.1-SNAPSHOT.jar'
                            }
                }


    }
}

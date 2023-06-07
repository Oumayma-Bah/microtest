pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Checkout source code from version control
        git 'https://github.com/Oumayma-Bah/microtest.git'

        // Build the project using Maven
        sh 'mvn clean install'
      }
    }

    stage('Docker Build') {
      steps {
        // Build Docker image
        sh 'docker build -t task2-image:latest .'
      }
    }

    stage('Docker Publish') {
      steps {
        // Publish Docker image to Docker registry
        withCredentials([usernamePassword(credentialsId: 'docker-registry-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
          sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
          sh 'docker push task2-image:latest'
        }
      }
    }

    stage('Deploy') {
      steps {
        // Deploy Docker image to target environment
        sh 'kubectl apply -f kubernetes-deployment.yaml' // Example: using Kubernetes
      }
    }
  }
}

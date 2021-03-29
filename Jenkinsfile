#!groovy
pipeline {

    agent any

    tools {
        jdk 'Java8'
        maven 'Maven3.6.3'
    }

    stages {
        stage('Initialize') {
            steps {
                sh '''
              echo "PATH = ${PATH}"
              echo "M2_HOME = ${M2_HOME}"
              echo "JAVA_HOME = ${JAVA_HOME}"
            '''
            }
        }
        stage('Build and Verify Pact') {
            steps {
                sh '''
                    mvn clean verify 
                    GIT_COMMIT=$(git log --format=format:%s -1)
                    mvn clean install  -Dpact.verifier.publishResults=true
                '''
            }
        }
        /*stage('Check Pact Verifications') {
          steps {
            sh 'curl -LO https://github.com/pact-foundation/pact-ruby-standalone/releases/download/v1.61.1/pact-1.61.1-linux-x86_64.tar.gz'
            sh 'tar xzf pact-1.61.1-linux-x86_64.tar.gz'
            dir('pact/bin') {
              sh "./pact-broker can-i-deploy -a user-service -b http://pact_broker -e ${GIT_COMMIT}"
            }
          }
        }*/
        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                echo 'Deploying to prod now...'
            }
        }
    }
}
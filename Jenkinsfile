pipeline {
    agent any

    tools {
        jdk 'JDK-17'            // Must match your Jenkins Global Tool name
        maven 'Maven-3.8'       // Must match your Jenkins Maven installation name
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build, Test & Generate Reports') {
            steps {
                // Run tests and generate reports in one go
                sh 'mvn clean verify -Dmaven.test.failure.ignore=true'
            }
            post {
                always {
                    // Publish JUnit test results
                    junit 'target/surefire-reports/*.xml'

                    // Publish Cucumber HTML Report
                    publishHTML(target: [
                        reportDir: 'target/cucumber-html-reports',
                        reportFiles: 'overview-features.html',
                        reportName: 'Cucumber HTML Report',
                        keepAll: true,
                        alwaysLinkToLastBuild: true
                    ])
                }
            }
        }

    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*', fingerprint: true
        }
        failure {
            echo "Build Failed: ${env.BUILD_URL}"
        }
    }
}
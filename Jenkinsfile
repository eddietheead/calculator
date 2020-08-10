pipeline {
    agent any
    triggers {
     pollSCM('* * * * *')
    }
    stages {
        stage("compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Unit Test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage("Code coverage") {
            steps {
                sh "./gradlew jacocotestreport"
		publishHTML(target: [reportDir: 'build/reports/jacoco/test/html',
                        reportFiles: 'index.html',
                        reportName: "Jacoco Report"
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("static code analysis") {
            steps {
                sh "./gradlew checkstyleMain"
		publishHTML(target: [reportDir: 'build/reports/checkstyle',
                        reportFiles: 'main.html',
                        reportName: "Checkstyle Report"
                ])
            }
        }
        stage("Package") {
            steps {
                sh "./gradlew build"
            }
        }
        stage("Docker build") {
            steps {
                sh "docker build -t ianedw123/iane:calculator ."
            }
        }
        stage("Docker Push") {
            steps {
                sh "docker push ianedw123/iane:calculator"
            }
        }
        stage("Acceptance test") {
            steps {
                sleep 60
                sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
            }
        }
        stage("Deploy to staging") {
            steps {
                sh "docker run -d --rm -p 8765:8080 --name calculator ianedw123/iane:calculator"
            }
        }
    }
    post {
     always {
       sh "docker stop calculator"
     }
    }
}

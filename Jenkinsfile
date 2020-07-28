pipeline {
    agent any
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
    }
}

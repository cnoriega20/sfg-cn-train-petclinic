pipeline{
    agent any

    stages{

        stage("build"){
            steps {
               powershell "mvn clean install"
            }
        }

        stage("Archive the artifacts") {
            steps{
                archiveArtifacts '**/target/*.jar'
            }
        }

        stage("test"){
            steps{
               junit '/**/target/surefire-reports/*TEST-**.xml'
            jacoco()
            }

        }
    }
}
pipeline{
    agent any

    stages{
        stage("checkout"){
            steps{
                git branch: "master", url: "https://github.com/cnoriega20/sfg-cn-train-petclinic"
            }
        }

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
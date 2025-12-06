import com.academy.buillds.Calculator

def call(Map pipelineParams) {
    Calculator calculator = new Calculator(this)

 pipeline
 {
    agent{
        label 'slave-1'
    }
     environment {
        APPLICATION_NAME = ${pipelineParams.appName}
     }
    stages{
        stage('Addition'){
            steps{
                script{
                    echo "adding method"
                    println calculator.add(2,3)
                }
            }

        }
        stage('build'){
            steps{
                echo "building Application"
            }
        }
     }
  }
}
package group001.problem3

object LargestPrimeFactor {

  def main (args: Array[String]) {
    val numero = 600851475143L

    def checkNextPrimeFor(forNum: Long, nextPrime: Long): Long = {
      if (nextPrime >= forNum)
        nextPrime
      else if (forNum % nextPrime == 0) {
        println("Div is: " + nextPrime)
        checkNextPrimeFor(forNum/nextPrime, nextPrime)
      } else {
        checkNextPrimeFor(forNum, nextPrime + 1)
      }
    }

    println("Biggest prime is: " + checkNextPrimeFor(numero, 2))



  }
}

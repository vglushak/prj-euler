package group001.problem10

import utils.Primes

object SumPrimes {

  def main(args: Array[String]) {

    val max = 2*1000*1000
    val sum = Primes.findPrimes(max).foldLeft(0L)((x, y) => 0L + x + y)
    println(s"Sum of primes before $max is $sum")
  }

}

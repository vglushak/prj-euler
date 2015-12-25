package group005.problem50

import utils.Primes

/**
 * Consecutive prime sum
 * Problem 50
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
object ConsequtivePrimes {

  def checkConseq(primes: List[Int], numLeft: Int, terms: Int): Int = {
    if (numLeft > 0 && primes.nonEmpty) {
      checkConseq(primes.tail, numLeft - primes.head, terms + 1)
    }
    else if (numLeft < 0 || primes.isEmpty) -1
    else terms
  }

  def checkLongestConseq(primes: List[Int], numLeft: Int, terms: Int, maxLng: Int = 0): Int = {
    if (primes.nonEmpty) {
      val lng = checkConseq(primes, numLeft, terms)
      checkLongestConseq(primes.tail, numLeft, terms, if (maxLng > lng) maxLng else lng)
    } else maxLng
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis()
    val maxNum = Math.pow(10, 5).toInt
    val ALL_PRIMES = Primes.findPrimes2(maxNum)

    println(ALL_PRIMES.par.reverseMap { p =>
      p -> checkLongestConseq(ALL_PRIMES.filter(_ < p), p, 0)
    }.toList.sortBy(-_._2).head)

    val finish = System.currentTimeMillis()
    println(s"Task done in ${finish - start}ms")
  }
}

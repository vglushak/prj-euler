package group002.problem12

import utils.Primes
import scala.annotation.tailrec

object Divisors {

  def main(args: Array[String]) {

    val primes = Primes.findPrimes(10000).map {
      _.toLong
    }

    def doAnalysis() {
      val start = System.currentTimeMillis()

      val trioNum = 1 until 15000

      @tailrec
      def divisorPowCount(num: Long, prime: Long, accum: Int): Int = {
        if (num % prime != 0) accum else divisorPowCount(num / prime, prime, accum + 1)
      }

      def findAllDivisors(initNum: Long): List[(Long, Int)] = {
        val res = primes.filter(_ <= initNum).map { p =>
          if (initNum % p == 0) Some((p, divisorPowCount(initNum, p, 0))) else None
        }.flatten
        res
      }

      // according to formula: if X = p1^t1*p2^t2... than total factors = (t1 + 1)*(t2 + 1)*...
      def divisorCount(divisors: List[(Long, Int)]) = {
        divisors.foldLeft(1)((x, y) => x * (y._2 + 1))
      }


      val rs = trioNum.map { n =>
        val tn = 1L * n * (n + 1) / 2
        val cnt = divisorCount(findAllDivisors(tn))
        val every = 1000
        if (tn % every == 0) println(s"Checked $every number is $tn divisor ${cnt}")
        (tn, cnt)
      }

      val finish = System.currentTimeMillis()

      // rs.foreach(println)
      val minEta = rs.find(_._2 > 500)
      val maxEtaNum = rs.sortBy(-_._2).head
      println(s"Num is: $minEta and greatest factors count is: ${maxEtaNum} found in ${finish - start}ms")
    }
    (0 until 1).foreach(x => doAnalysis())


  }
}
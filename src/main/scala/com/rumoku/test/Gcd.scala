package com.rumoku.test

import com.rumoku.util._

import scala.collection.mutable
import scala.math.pow

object Gcd {
  // GCD(1..20)

  def main(args: Array[String]) {
    val p = new PrimeNumber(20)
    p.collectPrimes(2)
    var primesMap = new mutable.HashMap[Int, Int]
    var tmp = 0
    var list = List[Int]()
    (1 to 20).toStream.foreach(i => list ::= i)


    p.primesArray.foreach(prime => {
      var x = 1
      var res = true
      (1 to 20).toStream.takeWhile(s => res).foreach(i => {
        x = i
        res = list.exists(s => s % pow(prime, x + 1) == 0)
      })
      primesMap += prime -> x
    }
    )
    var res = 1.0
    primesMap.foreach(el => res = res * pow(el._1, el._2))
    println(primesMap)
    println("Found minDivisible: " + res.toLong)
  }
}
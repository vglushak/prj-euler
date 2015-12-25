package com.rumoku.test

/**
 * Hello world!
 *
 */
object PrimeNumbers {

  val PRIMES_MAX_NUM = 50000
  var timeSpend = 0L
  var primesArray = List(2, 3, 5, 7)

  def getPrimeFactors(x: Long) = {
    var xx = x
    primesArray.foreach(s => while (xx % s == 0) {
      println(s)
      xx = xx / s
    })
    xx
  }

  def isPrime(x: Int) = {
    var res = true
    val startTime = System.currentTimeMillis()
    primesArray.takeWhile(e => res).foreach(s => if (x % s == 0) res = false)
    // above code is two time faster then below one
    def isPrimeImpl = {
      for (s <- primesArray)
        if (x % s == 0)
          false
      true
    }
    // res = isPrimeImpl
    timeSpend = timeSpend + (System.currentTimeMillis() - startTime)
    res
  }

  def collectPrimes(x: Int): Unit = {
    isPrime(x) match {
      case true => primesArray = primesArray ::: List(x)
      case false => primesArray
    }
    if (x < PRIMES_MAX_NUM) collectPrimes(x + 1)
    else return
  }

  def main(args: Array[String]) {
    val startTime = System.currentTimeMillis()
    collectPrimes(2)
    println(primesArray)
    println("Simplified to:" + getPrimeFactors(600851475143L))

    println("Divis time: " + timeSpend)
    println("Total time: " + (System.currentTimeMillis() - startTime))
  }
}












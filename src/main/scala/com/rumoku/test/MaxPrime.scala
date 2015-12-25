package com.rumoku.test

import com.rumoku.util.PrimeNumber

object MaxPrime {
  def main(args: Array[String]) {
    val time = System.currentTimeMillis()
    val MAX = 90000
    val primes = new PrimeNumber(1).reshetoEratosphena(MAX)
    println("Found primes: " + primes.length)
    println("Primes first: " + primes.head)
    println("Primes Last: " + primes.last)
    println("Spent time: " + (System.currentTimeMillis() - time))
    println("Interested: " + primes(10001))
  }
}
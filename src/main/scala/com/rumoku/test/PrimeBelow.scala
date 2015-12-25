package com.rumoku.test

import com.rumoku.util.PrimeNumber

// Problem 50
object PrimeBelow {
  def main(args: Array[String]) {
    var primeArray = new PrimeNumber(1).reshetoEratosphena(20000)
    println(primeArray)
    var res: Int = 0
    primeArray.foreach(x => res = x + res)
    println(res)
  }
}
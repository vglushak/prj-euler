package com.rumoku.test

object SumFactorialDigits {

  def main(args: Array[String]) {
    val f = getFactorial(100)
    val arr = f.toString().toList.map(_.toInt - 48)
    var res = 0
    arr.foreach(s => res = res + s)
    println(res)
  }

  def getFactorial(i: BigInt): BigInt = i > 0 match {
    case true => i * getFactorial(i - 1)
    case false => 1
  }
}
package com.rumoku.test

import io.Source


// Problem 13
object SumBigNums {

  val OUTPUT_DIR = "target/classes/"

  def getSumNums = {
    var bgint: BigInt = BigInt(0)
    for (line <- Source.fromFile(OUTPUT_DIR + "150numbers.txt").getLines) {
      println(line.trim)
      bgint += BigInt(line.trim)
    }
    println(bgint)
  }

  def getBig2In1000 = {
    var bgint: BigInt = BigInt(1)
    for (i <- 0 until 1000)
      bgint *= 2
    println("2^1000 = " + bgint)
    var res: Int = 0
    bgint.toString().toList.foreach(x => {res = (x.toInt-48) + res})
    print("Sum nums: " + res)
  }

  def main(args: Array[String]) {
    // getSumNums
    getBig2In1000
  }
}
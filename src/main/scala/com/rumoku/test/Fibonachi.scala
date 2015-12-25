package com.rumoku.test

/**
 * Hello world!
 *
 */
object Fibonachi {

  // Problem 2. By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
  val FIB_VAL_MAX_COUNT_TO = 4000001

  def getSumOfEvenValuedFibonachi(curr: Int, prev: Int): Int = {
    val next = curr + prev
    if (curr < FIB_VAL_MAX_COUNT_TO)
      (if (curr % 2 == 0) curr else 0) + getSumOfEvenValuedFibonachi(next, curr)
    else {
      0
    }
  }

  // Problem 25. What is the first term in the Fibonacci sequence to contain 1000 digits?
  def getFib1000thSeqTerm(curr: BigInt, prev: BigInt, num: Int): Int = {
    val next = curr + prev
    if (next.toString.length() == 1000)
      num + 1
    else
      getFib1000thSeqTerm(next, curr, num + 1)
  }

  def main(args: Array[String]) {
    // println(getSumOfEvenValuedFibonachi(1, 0))
    println(getFib1000thSeqTerm(1, 0, 1))
  }
}












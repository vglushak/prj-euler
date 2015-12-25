package com.rumoku.test

/**
 * Hello world!
 *
 */
object Palindrome {

  // Find the largest palindrome made from the product of two 3-digit numbers.
  def main(args: Array[String]) {
    var lastBiggestPal = 1
    for (i <- 100 until 999)
      for (j <- 100 until 999) {
        val mult = i * j

        val pal = ("" + mult).toList
        if (pal.length == 6 && isPalindrome(pal)) {
          if (mult > lastBiggestPal)
            lastBiggestPal = mult
        }
      }
    println(lastBiggestPal)
  }

  def isPalindrome(l: List[Char]): Boolean = l match {
    case Nil => true
    case x :: list => x == list.last && isPalindrome(list.take(list.length - 1))
  }

}













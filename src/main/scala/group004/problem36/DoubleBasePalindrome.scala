package group004.problem36

/**
 * Double-base palindromes
 * Problem 36
 * The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
object DoubleBasePalindrome {

  def main(args: Array[String]) {

    def binary(x: Int): List[Int] = {
      val n = (Math.log10(x) / Math.log10(2)).toInt
      val lft = x - Math.pow(2, n).toInt
      if (lft > 0) n :: binary(lft) else List(n)
    }

    def isBinPal(num: List[Int]) = {
      def isBinPal(num: List[Int], equ: Int): Boolean = {
        if (num.size == 0) true
        else if (num.size == 1) if (num.head == 1.0 * equ / 2) true else false
        else if (num.head + num.last != equ) false else isBinPal(num.tail.dropRight(1), equ)
      }
      isBinPal(num, num.head)
    }

    def isNumPal(num: Int) = {
      def isListPal(wrd: Array[Char]): Boolean = {
        if (wrd.size <= 1) true
        else if (wrd.head != wrd.last) false else isListPal(wrd.tail.dropRight(1))
      }
      isListPal(num.toString.toArray)

    }

    val start = System.currentTimeMillis()
    val rr = (1 until Math.pow(10,6).toInt).flatMap { x10 =>
      val x2 = binary(x10)
      val np = isNumPal(x10)
      val dp = isBinPal(x2)
      if (np && dp) Some(x10) else None
    }.sum
    println(rr)
    val end = System.currentTimeMillis()
    println(s"Done in: ${end-start}ms")
  }
}

// 872187
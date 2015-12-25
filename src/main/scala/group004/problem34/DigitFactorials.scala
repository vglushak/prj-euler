package group004.problem34

/**
 * Digit factorials
 * Problem 34
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
object DigitFactorials {

  def fact(x1: Int) = {
    def fact(x: Int, buff: Int): Int = {
      if (x == 1) buff else fact(x - 1, x * buff)
    }
    if (x1 == 0) 1 else fact(x1, 1)
  }



  val RNG = 0 to 9
  val SIMPLE_FACTS =  RNG.map(x => x -> fact(x)).toMap

  val MAX = SIMPLE_FACTS.map(_._2).sum

  def main(args: Array[String]) {

    println(SIMPLE_FACTS)
    println("Max is: " + MAX)

    val res = (10 to MAX).flatMap {x =>
      val numm = x.toString.toArray.map(x => ("" + x).toInt).map(SIMPLE_FACTS(_)).sum
      if (numm == x) Some(x) else None
    }

    println("WOW: " + res)

  }
}

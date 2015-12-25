package group002.problem17

/**
 * Number letter counts
 * Problem 17
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */
object NumberLetterCounter {
  val DIGIN_LETTER_MAP = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six", 7 -> "seven", 8 -> "eight", 9 -> "nine", 10 -> "ten",
    11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen")
  val TWENTY_MAP = Map(20 -> "twenty", 30 -> "thirty", 40 -> "forty", 50 -> "fifty", 60 -> "sixty", 70 -> "seventy", 80 -> "eighty", 90 -> "ninety")

  def main(args: Array[String]): Unit = {
    def numToLetter(i: Int) = {
      def numToLetter(x: Int, buff: List[String]): List[String] = {
        if (x == 0) buff
        else if (x < 20) buff ::: List(DIGIN_LETTER_MAP(x))
        else if (x < 100) TWENTY_MAP(10 * (x / 10)) :: numToLetter(x % 10, buff)
        else if (x < 1000) {
          val ss = numToLetter(x % 100, buff)
          val suff = if (ss.size == 0) ss else List("and") ::: ss
          numToLetter(x / 100, List()) ::: List("hundred") ::: suff
        }
        else List("one", "thousand")
      }
      numToLetter(i, List())
    }
    println((1 to 1000).map { i =>
      val k = numToLetter(i)
      println(k.mkString(" "))
      k.mkString("").size
    }.sum)
  }
}

// 21124

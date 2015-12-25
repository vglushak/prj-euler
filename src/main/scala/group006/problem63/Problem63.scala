package group006.problem63

/**
 * Problem 63
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
 * How many n-digit positive integers exist which are also an nth power?
 */

object PowerDigit {


  def collectPows(i: Int, next: BigInt, acc: Int): Int = {
    val powStr = next.pow(i).toString()
    if (powStr.length == i) println(s"$next^$i==$powStr")
    if  (powStr.length > i) acc else collectPows(i, next + 1, acc + (if (powStr.length == i) 1 else 0))
  }

  def main(args: Array[String]): Unit = {
    val r = (1 to 90).map { i =>
      val cp = collectPows(i, 1, 0)
      println(s"$i => $cp")
      cp
    }
    println(r.foldLeft(0)(_+_))
  }

}
// 49 nums at all
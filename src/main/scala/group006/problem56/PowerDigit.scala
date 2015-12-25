package group006.problem56

/**
 * Powerful digit sum
 * Problem 56
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 */
object PowerDigit {

  def main(args: Array[String]) {
    val rng = 1 to 99

    val r = rng.flatMap { a =>
      rng.map { b =>
        val pow = (1 to b).foldLeft(BigInt(1))((buf, bb) => buf * a)
        val r1 = pow.toString().toList.map(x => s"$x".toInt).sum
        r1
        // println(s"$a^$b -> $pow")
      }
    }.max
    println("Max sum of digits: " + r)
  }

}
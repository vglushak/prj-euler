package group001.problem5

import scala.annotation.tailrec

object SmallestMultiply {

  def main (args: Array[String]) {

    @tailrec
    def divisionOf(candidate: Int, divisors: List[Int]): Int = {
      if (divisors.forall(x => candidate % x == 0 )) candidate else divisionOf(candidate + 1, divisors)
    }

    println("Min Int: " + divisionOf(21, (2 to 20).reverse.toList))
  }
}

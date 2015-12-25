package group001.problem2

import scala.annotation.tailrec

object EvenFibonachi {

  def main (args: Array[String]) {

    val MaxValue = 4000000

    @tailrec
    def acumSum(prev1: Int, prev2: Int, accum: Int): Int = {
      val next = prev1 + prev2
      if (next > MaxValue ) accum else acumSum(prev2, next, if (next%2 == 0) accum + next else accum)
    }

    println(acumSum(1, 2, 2))
  }
}

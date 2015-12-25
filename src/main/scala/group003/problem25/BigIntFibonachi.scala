package group003.problem25

object BigIntFibonachi {

  def main(args: Array[String]) {

    def iFibonachi(i: Int, prev1: BigInt, prev2: BigInt, stop: BigInt => Boolean): (Int, BigInt) = {
      val next = prev1 + prev2
      if (stop(next)) (i, next) else iFibonachi(i + 1, prev2, next, stop)
    }

    println (iFibonachi(3, 1, 1, (i: BigInt) => i.toString().length == 1000))
  }
}

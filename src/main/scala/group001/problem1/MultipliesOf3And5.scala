package group001.problem1

object MultipliesOf3And5 {

  def main(args: Array[String]) {
    val res = progressionSumBefore(3, 3, 999) +
      progressionSumBefore(5, 5, 999) -
      progressionSumBefore(15, 15, 999)

    println("Res for 3,5 multiply problem is: " + res)

  }

  def progressionSumBefore(a1: Int, delta: Int, maxNum: Int) = {
    val n = maxNum / delta
    println(s"n for $a1 is $n")
    (2 * a1 + delta * (n - 1)) * n / 2
  }

}


package group005.problem48

object SelfPow {
  // problem 48

  def main(args: Array[String]): Unit = {


    def bigPow(i: BigInt, p: Int): BigInt = {
      if (p == 1) i else i * bigPow(i, p - 1)
    }
    val r = (1 to 1000).map(i => bigPow(BigInt(i), i)).sum
    println(r.toString())

  }
}
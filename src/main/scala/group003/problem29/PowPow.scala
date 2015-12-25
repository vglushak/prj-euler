package group003.problem29

object GreatPow {

  def main(args: Array[String]) {
    val range = 2 to 100
    var uniques = Set[BigInt]()

    def bigPow(a: Int, b: Int): BigInt = {
      if (b == 1) BigInt(a) else BigInt(a) * bigPow(a, b - 1)
    }
    range.foreach { x =>
      // println(s"$x")
      range.foreach { y =>
        val res = bigPow(x, y)
        uniques = Set(res) ++ uniques
      }
    }
    println(uniques size)
  }
}
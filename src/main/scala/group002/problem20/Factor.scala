package group002.problem20

object Factor {

  def main(args: Array[String]) {

    def factor(x: Int): BigInt = {
      if (x <= 1) BigInt(1) else BigInt(x) * factor(x - 1)
    }

    println(factor(100).toString().map(_.toString.toInt).sum)
  }
}

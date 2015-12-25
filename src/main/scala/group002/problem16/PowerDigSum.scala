package group002.problem16

object PowerDigSum {

  def main (args: Array[String]) {
    val x2 = BigInt(2)
    val pow = 1000
    // println(Math.pow(2, pow).toLong)
    println((0 until pow).foldLeft(BigInt(1))((x, y) => x*2).toString.map(z => ("" + z).toInt).sum)
  }
}

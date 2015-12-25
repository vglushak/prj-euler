package group001.problem9

object PhiphoTriple {

  def main(args: Array[String]) {

    val MaxNum = 1000
    val aC = 1 until MaxNum
    val bC = 1 until MaxNum
    val cC = 1 until MaxNum

    def pow2(x: Int) = Math.pow(x, 2).toInt

    val res = aC.map { a =>
      val bSols = bC.filter(b => a >= b).map { b =>
        val sols = cC.filter(c => a+b+c == MaxNum && a + b > c).filter { c => {
          val rC = pow2(c) == pow2(a) + pow2(b)
          if (rC) println(s"Candidates: $a, $b, $c")
          rC
        }}.toList
        (b, sols)
      }
      (a, bSols.filter(_._2.nonEmpty).flatMap(z => z._2.map(c => (z._1, c))).toList)
    }.filter(_._2.nonEmpty).map { z => z._2.map(bc => (z._1, bc._1, bc._2))}

    val collect = res.flatten.map{t => List(t._1, t._2, t._3)}.transpose.flatten
    val mult = collect.foldLeft(1)((x,y) => x * y)
    println(s"Nums are: $res => Multi is: $mult")
  }
}

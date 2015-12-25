package group001.problem4

import utils.NumHelpers

object PalindromeProduct {

  def main (args: Array[String]) {
    val r1 = 100 until 1000
    val r2 = 100 until 1000

    val pairs = r1.map { x =>
      val pp = r2.filter(y =>  y >= x ).filter { y =>
        val r = NumHelpers.isPolindrom((x*y).toString)
        if (r) println(s"$x & $y gives ${x*y}")
        r
      }
      (x, pp)
    }.filter(_._2.nonEmpty).map ( z => z._2.map(y => z._1 * y -> (z._1, y) ))
    println(pairs.flatten.sortBy(-_._1))

  }



}

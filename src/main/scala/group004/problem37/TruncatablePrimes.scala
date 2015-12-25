package group004.problem37

import utils.Primes

object TruncatablePrimes {

  val CPrimes = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  val Len = 3

  def main(args: Array[String]) {

    val Max = 100*1000
    val AllPrimes = Primes.findPrimes(Max)
    println(s"Primes found ${AllPrimes.size}")

    def combos(ranges: List[Int]): List[List[Int]] = ranges match {
      case hd :: tl => combos(tl).flatMap(cb => CPrimes.map(_ :: cb))
      case Nil => List(List())
    }

    def checkSubNumForPrimes(pr: List[Int], num: List[Int]): Boolean = num match {
      // check for 2 elements and more, do not check for 1 element
      case hd :: t1 =>
        pr.contains(num.mkString.toInt) && checkSubNumForPrimes(pr, num.tail) && checkSubNumForPrimes(pr, num.dropRight(1))
      // case hd :: Nil if (num.isEmpty) => println(s"WTF: $hd"); true
      // case hd :: t1 :: Nil => pr.contains(num.mkString.toInt)
      case Nil => true

    }

    (2 to 5).map {x =>
      val l = List.fill(x)(0)
      val maxX = Math.pow(10, x)
      val ourPrimes = AllPrimes.filter(p => p < maxX)
      println(s"Check primes before $maxX")
      // filter even -> convert to number -> check if in list
      val res = combos(l).filter(x => !x.contains(2) || x.lastIndexOf(2) == 0).
        map(x => x -> x.mkString.toInt).
        filter(x => checkSubNumForPrimes(ourPrimes, x._1))
      res.map(x => println(x._2))

    }
  }

}

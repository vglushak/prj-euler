//package coldility.test
//
//
//import scala.collection.JavaConversions._
//import scala.annotation.tailrec
//
//object Solution {
//
//  import Math._
//
//  def solution(A: Array[Int]): Array[Int] = {
//
//    @tailrec
//    def getNearestI(x: Int, i: Int): Int = {
//      val pow2 = pow(-2, i)
//      val pow21 = if (i > 2) pow(-2, i - 2)  else 0  // ???
//      // println(s"$x > $i > $pow2 > $pow21")
//      if (signum(x) == signum(pow2) && abs(pow2) >= abs(x) - abs(pow21)) i else getNearestI(x, i + 1)
//
//    }
//
//    @tailrec
//    def splitNum(x: Int, ac: List[Int]): List[Int] = {
//      val nextI = getNearestI(x, 0)
//      val nextX = x - pow(-2, nextI)
//      println(s"$x -> $nextI -> $nextX")
//      if (nextX == 0) ac ::: List(nextI) else splitNum(nextX.toInt, ac ::: List(nextI))
//    }
//
//    // num first, index second
//    val num = A.zipWithIndex.map(x => x._1 * Math.pow(-2, x._2).toInt).sum
//
//    val res = splitNum(-1 * num, List())
//    (0 to res.head).map(x => if (res.contains(x)) 1 else 0).toArray
//  }
//}
//
//
//object BitsToMinusBits {
//  def main(args: Array[String]) {
//    println(Solution.solution(Array(1, 0, 0, 1, 1)).toList)
//    println(Solution.solution(Array(1, 0, 0, 1, 1, 1)).toList)
//  }
//
//}

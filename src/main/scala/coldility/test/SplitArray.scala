package coldility.test




import scala.collection.JavaConversions._
import scala.annotation.tailrec

object Solution {
  def solution(X: Int, A: Array[Int]): Int = {

    @tailrec
    def dropRightNonX(x: Int, a: Array[Int]): Option[Array[Int]] = {
      if (a.size == 0) None
      else if (a.last != x) Some(a.dropRight(1))
      else dropRightNonX(x, a.dropRight(1))
    }

    @tailrec
    def findMid(init: Boolean, mid: Int, x: Int, a: Array[Int]): Int = {
      a.toList match {
        case h :: tail if (h != x) => findMid(init, mid + 1, x, a.tail)
        case h :: tail if (h == x) => {
          val dr = dropRightNonX(x, a.tail)
          if (dr.isDefined) findMid(true, mid + 1, x, dr.get) else -1
        }
        case h :: Nil => -1
        case List() =>  if (init) mid else -1
      }
    }

    findMid(false, 0, X, A)
  }
}

object SplitArray {

  def main(args: Array[String]) {
    println(Solution.solution(5, Array(5, 5, 1, 7, 2, 3, 5)))
    println(Solution.solution(5, Array(5, 5, 5, 7, 2, 3, 5)))
    println(Solution.solution(5, Array(5, 5, 5, 7, 2, 3)))
    println(Solution.solution(5, Array(5, 5, 5, 5, 2, 3, 5)))
    println(Solution.solution(8, Array(5, 5, 1, 7, 2, 3, 5)))
    println(Solution.solution(5, Array(1, 2, 3, 4, 4, 5)))
  }

}
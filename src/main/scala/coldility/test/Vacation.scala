package coldility.test

object Vacation {

  def main(args: Array[String]) {
    println(Solution1.solution(Array(1, 1, 0, 1, 0, 0, 1, 1)))
    println(Solution1.solution(Array(1, 0)))
  }

}


object Solution1 {

  def solution(A: Array[Int]): Int = {
    def isAcceptable(swim: Array[Int], mount: Array[Int]): Int = {
      if (swim.size == 0 || mount.size == 0) return 0
      else if (swim.filter(_ == 0).size > swim.size / 2 && mount.filter(_ == 1).size > mount.size / 2) {
        swim.size + mount.size
      }
      else isAcceptable(swim ++ Array(mount.head), mount.tail)
    }

    def doCalc(A: Array[Int]): Int = {
      val x = if (A.size > 1) isAcceptable(Array(A.head), A.tail) else 0
      if (x == 0 && A.size > 1) {
        if (A.head == 1) doCalc(A.tail)
        else if (A.last == 0) doCalc(A.dropRight(1))
        else 0
      } else x
    }

    doCalc(A)

  }

}
package group002.problem14
import scala.annotation.tailrec

object Collaz {

  def main(args: Array[String]) {
    @tailrec
    def calcCollazSeq(start: Long, accumSize: Long): Long = {
      if (start == 1) 1 + accumSize
      else if (start % 2 == 0) calcCollazSeq(start / 2, 1 + accumSize)
      else calcCollazSeq(3 * start + 1, 1 + accumSize)
    }

    @tailrec
    def collectCollazSeq(start: Int, accum: List[Int]): List[Int] = {
      if (start == 1) 1 :: accum
      else if (start % 2 == 0) collectCollazSeq(start / 2, start :: accum)
      else collectCollazSeq(3 * start + 1, start :: accum)
    }

    def allCollaz(maxNum: Int) = {
      (2 until maxNum).map(x => x -> collectCollazSeq(x, Nil))
    }

    def allCollazLength(maxNum: Int) = {
      (2 until maxNum).map(x => x -> calcCollazSeq(x, 0))
    }

    val start = System.currentTimeMillis()
    println(allCollazLength(1000000).toList.sortBy(-_._2).head._1)
    val finish = System.currentTimeMillis()
    println(s"Taken: ${finish - start}")
  }

}
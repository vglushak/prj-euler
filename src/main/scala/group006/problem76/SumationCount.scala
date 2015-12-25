package group006.problem76

/**
 * Counting summations
 * Problem 76
 * It is possible to write five as a sum in exactly six different ways:
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 * How many different ways can one hundred be written as a sum of at least two positive integers?
 */
object SumationCount {

  val NUM = 100
  val RNG = 1 to NUM - 1
  def main (args: Array[String]) {

    def count(minNum: Int, leftNum: Int, buf: List[List[Int]]): List[List[Int]] = {
      if (leftNum == 0) buf
      else {
        val r = (minNum to leftNum).par.flatMap { i =>
          count(i, leftNum - i, buf.map(i :: _))
        }.toList
        r
      }
    }
    def count2(minNum: Int, leftNum: Int): Long = {
      if (leftNum == 0) 1L
      // else if (leftNum == 5) 6L
      else {
        val r = (minNum to leftNum).map { i =>
          count2(i, leftNum - i)
        }.sum
        r
      }
    }

    count(1, 5, List(List())).foreach(println)
    val start = System.currentTimeMillis()
    // println(count(1, 60, List(List())).size)
    println(count2(1, 60))
    val finish = System.currentTimeMillis()
    println(s"Done in ${finish-start}ms")
  }
}
/*
190569292
Done in 172078ms
 */

package group001.problem6

object SumSquareDiff {
  def main(args: Array[String]) {
    val MaxValue = 100
    val sumSq = Math.pow((1L + MaxValue) * MaxValue / 2, 2).toLong
    println(sumSq)
    val sqSum = (1 until MaxValue + 1).map(Math.pow(_, 2).toLong).foldLeft(0L)((z, x) => z + x)
    println(sqSum)
    println("Diff is " + (sumSq - sqSum))
  }
}

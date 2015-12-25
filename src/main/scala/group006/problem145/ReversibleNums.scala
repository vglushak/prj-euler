package group006.problem145


object ReversibleNums {
  // https://projecteuler.net/problem=145

  def main(args: Array[String]): Unit = {

    val start = System.currentTimeMillis()

    val Even = List(0,2,4,6,8)
    def isSumEven(x: Int) = x % 2 == 0

    def isGoodSum(a: Array[Int], b: Array[Int], next: Int): Boolean = {
      val in = a.head + b.head + next
      if (isSumEven(in)) false else {
        if (a.size == 1) true
        else isGoodSum(a.tail, b.tail, if(in > 9) 1 else 0)
      }

    }

    val rev = (1 to Math.pow(10, 6).toInt).map { x => {

      val direct = x.toString.toCharArray.map(f => s"$f".toInt)
      val headEven = Even.contains(direct.head)
      val lastEven = Even.contains(direct.last)
      val evenn = (headEven, lastEven) match {
        case (true, true) => true
        case (false, false) => true
        case (_, _) => false
      }

      val isGoodNum = if (evenn) {
        false
      } else {
        val revert = direct.reverse
        isGoodSum(direct, revert, 0)
      }
      x -> isGoodNum
    }}.filter(x => x._2)

    println(rev.map(_._1))
    println(rev.map(_._1).size)

    val end = System.currentTimeMillis()
    println(s"Time: ${end - start}ms")
  }

}
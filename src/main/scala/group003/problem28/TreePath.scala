package group003.problem28

object TreePath {



  def main (args: Array[String]) {
    val N = 1001

    def next(x: Int) = {
      val x4 = x*x
      val x3 = x4 - x + 1
      val x2 = x3 - x + 1
      val x1 = x2 - x + 1
      x4 + x3 + x2 + x1
    }
    val r = (0 to N/2 - 1).map(x => next(2*x + 3))
    println(r.sum + 1)
  }

}
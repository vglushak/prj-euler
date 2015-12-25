package group002.problem15
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

object LaticePath {

  def main(args: Array[String]): Unit = {


    def laticePath(size: Int) = {
      val deep = size

      // @tailrec
      def nextStep(x: Int, y: Int): Long = {
        // println(s"Check for [$x,$y]")
        if (x == deep || y == deep) 1L
        else {
          if (x == 2 || y == 2) {
            val fut = Future {
              nextStep(x + 1, y) + nextStep(x, y + 1)
            }
            Await.result(fut, 10 hours)
          } else {
            nextStep(x + 1, y) + nextStep(x, y + 1)
          }
          // else if (x < deep) nextStep(x + 1, y) else nextStep(x, y + 1)
        }
      }
      nextStep(0, 0)
    }

    val start = System.currentTimeMillis()
    println(laticePath(20))
    val finish = System.currentTimeMillis()
    println(s"Done in ${finish-start}ms")

  }
}
package group003.problem30

object SumOfPow {

  def checkFor5 = {
    val pow = 5
    val range = 0 to 9
    val res = range.map { x1 => range.map { x2 => range.map { x3 =>
      range.map { x4 => range.map { x5 => range.map { x6 => range.map { x7 =>
        val res = s"$x1$x2$x3$x4$x5$x6$x7".toInt
        if (res == (Math.pow(x1, pow) + Math.pow(x2, pow) + Math.pow(x3, pow) +
          Math.pow(x4, pow) + Math.pow(x5, pow) + Math.pow(x6, pow) + Math.pow(x7, pow)
          ).toInt) {
          Some(res)
        } else None
      }
      }
      }
      }
    }
    }
    }
    val r1 = res.flatten.flatten.flatten.flatten.flatten.flatten.flatten
    println(r1)
    println(r1.sum)
  }

  def checkFor4 = {
    val res = (0 to 9).map { x1 =>
      (0 to 9).map { x2 =>
        (0 to 9).map { x3 =>
          (0 to 9).map { x4 =>
            if (s"$x1$x2$x3$x4".toInt == (Math.pow(x1, 4) +
              Math.pow(x2, 4) +
              Math.pow(x3, 4) +
              Math.pow(x4, 4)).toInt) {
              val res = s"$x1$x2$x3$x4".toInt
              Some(res)
            } else None
          }
        }
      }
    }
    val r1 = res.flatten.flatten.flatten.flatten
    println(r1)
    println(r1.sum)
  }

  def main(args: Array[String]) {
    checkFor4
    checkFor5
  }
}
package group004.problem31

object CoinsFlip {

  def main (args: Array[String]) {
    def combos(list: List[Int]): List[List[Int]] = list match {
      case hd::tl => combos(tl).flatMap{ combo => (0 to hd).map(_ :: combo) }
      case Nil => List(List())
    }

    println(combos(List(5, 5 ,5)))
  }

}


object CoinsFlipBrutForce {


  def main(args: Array[String]) {

    val Target = 200
    val Nums = List(1, 2, 5, 10, 20, 50, 100, 200).reverse

    val ranges = Nums.map { n => (n, 0 to Target / n)}
    val r = ranges(0)._2.map { r1 =>
      // println(s"$r1/$Target doing...")
      val s1 = Nums(0) * r1
      ranges(1)._2.filter(x => Nums(1) * x <= Target - s1).map { r2 =>
        val s2 = s1 + Nums(1) * r2
        ranges(2)._2.filter(x => Nums(2) * x <= Target - s2).map { r3 =>
          val s3 = s2 + Nums(2) * r3
          ranges(3)._2.filter(x => Nums(3) * x <= Target - s3).map { r4 =>
            val s4 = s3 + Nums(3) * r4
            ranges(4)._2.filter(x => Nums(4) * x <= Target - s4).map { r5 =>
              val s5 = s4 + Nums(4) * r5
              ranges(5)._2.filter(x => Nums(5) * x <= Target - s5).map { r6 =>
                val s6 = s5 + Nums(5) * r6
                ranges(6)._2.filter(x => Nums(6) * x <= Target - s6).map { r7 =>
                  val s7 = s6 + Nums(6) * r7
                  ranges(7)._2.filter(x => Nums(7) * x <= Target - s7).map { r8 =>
                    val sum = s7 + Nums(7) * r8
                    val l = List(r1, r2, r3, r4, r5, r6, r7, r8)
                    if (sum == Target) Some(l -> true) else None
                  }
                }
              }
            }
          }
        }
      }
    }
    val rr = r.flatten.flatten.flatten.flatten.flatten.flatten.flatten.flatten
    // println(rr)
    println(rr.size)

  }

}
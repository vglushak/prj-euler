package tasks

/**
 * Totient maximum
 * Problem 69
 * Euler's Totient function, ?(n) [sometimes called the phi function], is used to determine the number of numbers less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, ?(9)=6.
 * n	Relatively Prime	?(n)	n/?(n)
 * 2	1	1	2
 * 3	1,2	2	1.5
 * 4	1,3	2	2
 * 5	1,2,3,4	4	1.25
 * 6	1,5	2	3
 * 7	1,2,3,4,5,6	6	1.1666...
 * 8	1,3,5,7	4	2
 * 9	1,2,4,5,7,8	6	1.5
 * 10	1,3,7,9	4	2.5
 * It can be seen that n=6 produces a maximum n/?(n) for n ? 10.
 * Find the value of n ? 1,000,000 for which n/?(n) is a maximum.
 *
 * TODO:
 * FIXME:
 */
object TotientMax {

  def main(args: Array[String]) {

    def isRelaPrime(x: Int, num: Int) = {
      if (x % num == 0) false
      else {

      }
    }
    def getRelPrimes(x: Int, nextNum: Int, buf: List[Int]): List[Int] = {
      if (nextNum == x) buf
      else getRelPrimes(x, nextNum + 1, if (x % nextNum == 0) buf else nextNum :: buf)
    }


  }

}

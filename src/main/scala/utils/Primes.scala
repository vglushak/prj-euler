package utils

import scala.annotation.tailrec

object Primes {

  def findPrimes(maxNum: Int) = {
    @tailrec
    def eratospheImpl(arr: Array[Int], acc: Array[Int]): Array[Int] = {
      val prime = arr.head
      if (arr.size == 1) acc ++ Array(prime)
      else eratospheImpl(arr.tail.filter(i => i % prime != 0), acc ++ Array(prime))
    }

    def eratosphe(arr: Array[Int]): Array[Int] = {
      eratospheImpl(arr, Array.empty[Int])
    }

    val start = System.currentTimeMillis()
    val arr = Array.range(2, maxNum)
    val primes = eratosphe(arr).toList
    val finish = System.currentTimeMillis()
    println(s"[Impl1]Get ${primes.size} before $maxNum primes for ${finish - start}ms. Max prime is ${primes.last}")
    // println(s"10001 element is ${primes(10001-1)}")
    primes
  }

  def findPrimes2(maxNum: Int) = {
      @tailrec
      def eratospheImpl(arr: List[Int], acc: List[Int]): List[Int] = {
        val prime = arr.head
        if (arr.size == 1) prime :: acc
        else eratospheImpl(arr.tail.filter(i => i % prime != 0), prime :: acc)
      }

      def eratosphe(arr: List[Int]): List[Int] = {
        // prepare list....
        val smallArr = arr.dropRight(arr.size / 2)
        val smallPrimes = eratospheImpl(smallArr, List()).reverse
        //
        val filteredArr = arr.filter(i => smallPrimes.forall(sP => i % sP != 0))
        eratospheImpl(filteredArr, smallPrimes).reverse
      }

      val start = System.currentTimeMillis()
      val arr = Array.range(2, maxNum).toList
      val primes = eratosphe(arr)
      val finish = System.currentTimeMillis()
      println(s"[Impl2]Get ${primes.size} before $maxNum primes for ${finish - start}ms. Max prime is ${primes.last}")
      primes
    }

  def main (args: Array[String]) {
    (0 to 10).map { x =>
      findPrimes2(100000)
      findPrimes(100000)
      x
    }.sum
//    findPrimes2(200000)
//    findPrimes(200000)

  }

}

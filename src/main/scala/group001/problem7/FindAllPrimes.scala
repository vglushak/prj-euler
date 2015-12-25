package group001.problem7

import scala.annotation.tailrec

object FindAllPrimes {

  def main(args: Array[String]) {

    @tailrec
    def eratospheImpl(arr: Array[Int], acc: Array[Int]): Array[Int] = {
      val prime = arr.head
      if (arr.size == 1) acc ++ Array(prime)
      else eratospheImpl(arr.tail.filter(i => i % prime != 0), acc ++  Array(prime))
    }

    def eratosphe(arr: Array[Int]): Array[Int] = {
      eratospheImpl(arr, Array.empty[Int])
    }

    def findPrimes(maxNum: Int) {
      val start = System.currentTimeMillis()
      val arr = Array.range(2, maxNum)
      val primes = eratosphe(arr).toList
      println(primes)
      val finish = System.currentTimeMillis()
      println(s"Get ${primes.size} before $maxNum primes for ${finish - start}ms. Max prime is ${primes.last}")
      // println(s"10001 element is ${primes(10001-1)}")
    }
//    findPrimes(100)
//    findPrimes(1000)
//    findPrimes(10000)
//    findPrimes(100000)
    findPrimes(200000)
  }

}

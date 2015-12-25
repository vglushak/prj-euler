package group006

/**
  * Permuted multiples
  * Problem 52
  * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
  * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
  */
object PermutedMultiplies {

   implicit class RichLong(n: Long) {
     def orderStr = n.toString.toCharArray.sorted.mkString("")
   }

   def main(args: Array[String]) {


     println(doFind(125874L))

     def sameNums(sortedEta: String, candidate: Long) = sortedEta == candidate.orderStr


     def doFind(next: Long): Long = {
       val nStr = next.orderStr
       if (sameNums(nStr, next * 2) && sameNums(nStr, next * 3) && sameNums(nStr, next * 4) &&
         sameNums(nStr, next * 5) && sameNums(nStr, next * 6)) {
         next
       } else {
         doFind(next + 1)
       }
     }
   }
 }

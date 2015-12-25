package group006.problem79

/**
 * Passcode derivation
 * Problem 79
 * A common security method used for online banking is to ask the user for three random characters from a passcode. For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.
 * The text file, keylog.txt, contains fifty successful login attempts.
 * Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.
 *
 */
object PasscodeDerivation {

  val ATTEMPTS = List(319, 680, 180, 690, 129, 620, 762, 689, 762, 318, 368, 710, 720, 710, 629, 168, 160, 689, 716, 731, 736, 729, 316, 729, 729, 710, 769, 290, 719, 680, 318, 389, 162, 289, 162, 718, 729, 319, 790, 680, 890, 362, 319, 760, 316, 729, 380, 319, 728, 716)
  val ATT = ATTEMPTS.map(_.toString)

  case class Pairs(l: Char, r: Char) {}

  def main(args: Array[String]) = {
    def buildPairsFromStr(sq: List[Char], buff: List[Pairs]): List[Pairs] = {
      if (sq.size < 2) buff
      else {
        buildPairsFromStr(sq.tail, Pairs(sq.head, sq.tail.head) :: buff)
      }
    }
    def buildPairs(att: List[String], buff: List[Pairs]): List[Pairs] = {
      if (att.isEmpty) buff
      else {
        val s1 = att.head
        buildPairs(att.tail, buildPairsFromStr(s1.toCharArray.toList, buff))
      }
    }

    val pairs = buildPairs(ATT, List()).toSet

    val firstCandidates = ATT.map(_.head).toSet
    val lastCandidates = ATT.map(_.last).toSet
    val numsInList = ATT.mkString("").toCharArray.toSet
    val minSize = numsInList.size
    println(pairs)
    println(firstCandidates)
    println(lastCandidates)
    println(numsInList)

    pairs.foreach(x => buildSeq(x, List(x)))
    // buildSeq(Pairs('7', '3'), List())

    def buildSeq(next: Pairs, buff: List[Pairs]): Unit = {
      val nextSteps = pairs.filter(!buff.contains(_)).filter(p => p.l == next.r)
      if (nextSteps.isEmpty) {
        if (buff.size >= minSize - 1) println(buff.mkString("->"))
      }
      else nextSteps.map(n => buildSeq(n, buff ::: List(n)))
    }
  }

}

// 73162890

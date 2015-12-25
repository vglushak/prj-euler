package group002.problem19

/**
 * Counting Sundays
 * Problem 19
 * You are given the following information, but you may prefer to do some research for yourself.
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

object CountingSundays {

  val MOUNTH_MAP = Map(1 -> 31, 3 -> 31, 4 -> 30, 5 -> 31, 6 -> 30, 7 -> 31, 8 -> 31, 9 -> 30, 10 -> 31, 11 -> 30, 12 -> 31)

  val DAY_ARR = Map("Mon" -> "Tue", "Tue" -> "Wed", "Wed" -> "Thu", "Thu" -> "Fri", "Fri" -> "Sat", "Sat" -> "Sun", "Sun" -> "Mon")

  val JAN_5_SUN = List("Fri", "Sat", "Sun")

  def calcFeb(year: Int) = if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28

  def calcDaysShift(startDay: String, days: Int) = {
    val shift = days % 7
    if (shift > 0) nextDay(startDay, shift) else startDay
  }

  def nextDay(startDay: String, x: Int): String = {
    val n = DAY_ARR(startDay)
    if (x == 1) n else nextDay(n, x - 1)
  }

  def calcYearDays(year: Int) = 337 + calcFeb(year)

  def getMonthDays(year: Int, mon: Int) = {
    if (mon == 2) calcFeb(year) else MOUNTH_MAP(mon)
  }

  def main(args: Array[String]) {

    def sunCounter(startDay: String, year: Int, month: Int, yearTo: Int): Int = {
      if (year > yearTo) 0
      else {
        println(s"$startDay [$month:$year]")
        val newStartDay = calcDaysShift(startDay, getMonthDays(year, month))
        val count = if (startDay == "Sun") 1 else 0
        count + sunCounter(newStartDay, if (month < 12) year else year + 1, if (month < 12) month + 1 else 1, yearTo)
      }
    }

    def recSunCounter(startDay: String, year: Int, yearTo: Int): Int = {
      val days = calcYearDays(year)
      val ds = if (JAN_5_SUN.contains(startDay)) 5 else 4
      println(s"$year -> $startDay -> $ds")
      ds + (if (year == yearTo) 0 else recSunCounter(calcDaysShift(startDay, days), year + 1, yearTo))
    }

    // println(recSunCounter("Tue", 1901, 2000))
    println(sunCounter("Tue", 1901, 1, 2000))


  }

}

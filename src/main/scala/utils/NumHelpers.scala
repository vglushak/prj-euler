package utils

object NumHelpers {

  def isPolindrom(asStr: String): Boolean = {
    if (asStr.length < 2) {
      true
    } else if (asStr.head != asStr.last) {
      false
    } else {
      isPolindrom(asStr.tail.dropRight(1))
    }
  }
}

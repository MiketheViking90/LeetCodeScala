package algorithms

import scala.collection.mutable

object LongestSubstringWithoutRepeat {

  def lengthOfLongestSubstring(s: String): Int = {
    if (s == null) {
      return 0
    }

    val len = s.length
    if (len == 0 || len == 1) {
      return len
    }

    var maxLen = 1
    val charCounts = new mutable.HashMap[Char, Int]()
    var i = 0
    var j = 1
    val iChar = s.charAt(i)
    charCounts.put(iChar, 1)

    val jChar = s.charAt(j)
    if (jChar != iChar) {
      maxLen = 2
    }
    val jCount = charCounts.getOrElse(jChar, 0)
    charCounts.put(jChar, jCount + 1)

    while (j < len) {
      if (allUnique(charCounts)) {
        maxLen = Math.max(maxLen, j - i + 1)
        j += 1
        if (j < len) {
          val jChar = s.charAt(j)
          val jCount = charCounts.getOrElse(jChar, 0)
          charCounts.put(jChar, jCount + 1)
        }
      } else {
        val iChar = s.charAt(i)
        val iCount = charCounts.get(iChar).get
        charCounts.put(iChar, iCount - 1)
        i += 1
      }
    }

    maxLen
  }

  def allUnique(charCounts: mutable.HashMap[Char, Int]): Boolean = {
    for (i <- charCounts.values) {
      if (i > 1) {
        return false
      }
    }

    return true
  }

  def main(args: Array[String]): Unit = {
    val str = "aab";
    val len = lengthOfLongestSubstring(str)
    println(len)
  }

}

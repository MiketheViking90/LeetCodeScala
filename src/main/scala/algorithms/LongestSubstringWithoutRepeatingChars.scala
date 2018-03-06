package algorithms

import scala.collection.mutable

object LongestSubstringWithoutRepeatingChars {

  def lengthOfLongestSubstring(s: String): Int = {
    val n = s.length

    val charCounts = new mutable.HashMap[Char, Int]
    charCounts.put(s.charAt(0), 1)
    var i = 0
    var j = 1
    while (i < n) {
      val char = s.charAt(j)
      val cnt = charCounts.getOrElse(char, 0)


    }
    0
  }

}

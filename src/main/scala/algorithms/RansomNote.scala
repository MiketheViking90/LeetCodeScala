package algorithms

import scala.collection.mutable

object RansomNote {

  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val magCounts = new mutable.HashMap[Char, Int]
    for (c <- magazine) {
      val cnt = magCounts.getOrElse(c, 0)
      magCounts.put(c, cnt+1)
    }

    for (c <- ransomNote) {
      if (!magCounts.contains(c)) {
        return false
      }

      val cnt = magCounts(c)
      if (cnt == 0) {
        return false
      }
      magCounts.put(c, cnt - 1)
    }

    true
  }

  def main(args: Array[String]): Unit = {
    canConstruct("aa", "ab")
  }
}

package algorithms

import scala.collection.mutable

object FirstUniqueCharacterInString {

  def firstUniqChar(s: String): Int = {
    val charToCnt = new mutable.HashMap[Char, Int]
    for (c <- s.toCharArray) {
      val curCnt = charToCnt.getOrElse(c, 0)
      charToCnt.put(c, curCnt+1)
    }

    for (i <- 0 until s.length) {
      val c = s.charAt(i)
      if (charToCnt(c) == 1) {
        return i
      }
    }

    -1
  }

}

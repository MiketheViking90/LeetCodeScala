package algorithms

object LongestCommonPrefix {

  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs == null || strs.length == 0) {
      return ""
    }

    var i = 0
    while (true) {
      val str = strs(0)
      if (str.length <= i) {
        return str
      }

      val prefix = strs(0).charAt(i)

      for (str <- strs) {
        if (str.length <= i) {
          return str
        }
        if (str.charAt(i) != prefix) {
          return str.substring(0, i)
        }
      }

      i += 1
    }
    ""
  }

  def main(args: Array[String]): Unit = {
    val strs = Array("c", "aab", "aaa")
    val pre = longestCommonPrefix(strs)
    println(pre)
  }

}

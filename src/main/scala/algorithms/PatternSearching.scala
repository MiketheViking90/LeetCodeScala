package algorithms

object PatternSearching extends App {

  def hasPattern(sentence: String, pattern: String) : Boolean = {
    val patternLen = pattern.length
    val len = sentence.length
    for (i <- 0 until (len - patternLen)) {
      if (sentence.substring(i, i+patternLen).equals(pattern)) {
        return true;
      }
    }
    return false;
  }

  val b = hasPattern("geeksForGeeks", "gee")
  println(b)

}

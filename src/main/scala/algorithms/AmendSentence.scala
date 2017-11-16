package algorithms

object AmendSentence extends App {

  def amendString(sentence: String) : String = {
    val sb = new StringBuilder

    for (c <- sentence ) {
      if (c.isUpper) {
        sb.append(" " + c.toLower)
      } else {
        sb.append(c)
      }
    }

    sb.toString
  }

  val s = "BruceWayneIsBatman"
  val amend = amendString(s)
  println(amend)

}

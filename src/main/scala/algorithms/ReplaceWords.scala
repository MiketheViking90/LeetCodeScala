package algorithms

object ReplaceWords {

  def replaceWords(dict: List[String], sentence: String): String = {
    val words = sentence.split(" ")
    val dictSet = dict.toSet

    for (i <- 0 until words.length) {
      val word = words(i)

      for (dWord <- dict) {
        if (dWord.length < word.length) {
          if (word.startsWith(dWord)) {
            words(i) = dWord
          }
        }
      }
    }

    return words.deep.mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    val replaced = replaceWords(List("cat", "bat", "rat"), "the cattle was rattled by the battery")
    println(replaced)
  }
}

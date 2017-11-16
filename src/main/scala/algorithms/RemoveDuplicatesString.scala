package algorithms

import scala.collection.mutable

object RemoveDuplicatesString extends App {

  def removeDuplicates(str:String) : String = {
    val seenChars = new mutable.LinkedHashSet[Char]
    for (c <- str) {
      if (!seenChars.contains(c)) {
        seenChars.add(c)
      }
    }

    val sb = new StringBuilder();
    for (c <- seenChars) {
      sb.append(c)
    }
    sb.toString()
  }

  val s = removeDuplicates("twosigmaisgreat")
  print(s)
}

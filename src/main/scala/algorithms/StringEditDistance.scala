package algorithms

object  StringEditDistance extends App {

  def getDistance(str1:String, str2:String) : Int = {
    val len1 = str1.length()
    val len2 = str2.length()
    val M = Array.ofDim[Int](len1+1, len2+1)

    for (i <- 1 to len1) {
      val c1 = str1(i-1)

      for (j <- 1 to len2) {
        val c2 = str2(j-1)

        if (c1 == c2) {
          M(i)(j) = M(i-1)(j-1)
        } else {
          val delete = M(i-1)(j)
          val swap = M(i)(j-1)
          M(i)(j) = Math.min(delete, swap) + 1
        }
      }
    }

    M(len1)(len2)
  }

  val d = getDistance("asdf", "adf")
  print(d)
}

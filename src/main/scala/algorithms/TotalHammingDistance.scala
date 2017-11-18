package algorithms

object TotalHammingDistance {

  def totalHammingDistance(nums: Array[Int]): Int = {
    0
  }

  private def getHammingDist(a: Int, b: Int): Int = {
    var xor = a^b
    var cnt = 0

    while (xor > 0) {
      val mask = (xor & (xor-1))
      xor >> 2
    }

    cnt
  }


  def main(args: Array[String]): Unit = {
    val dist = getHammingDist(2, 6)
    println(dist)
  }
}
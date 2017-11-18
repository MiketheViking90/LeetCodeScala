package algorithms

object TotalHammingDistance {

  def totalHammingDistance(nums: Array[Int]): Int = {
    val len = nums.length
    var dist = 0
    for (i <- 0 until len - 1) {
      val a = nums(i)

        for (j <- i+1 until len) {
          val b = nums(j)
          if (a != b) {
            println(a + ", " + b + ": " + getHammingDist(a, b))
            dist += getHammingDist(a, b)
          }
      }
    }

    dist
  }

  private def getHammingDist(a: Int, b: Int): Int = {
    var xor = a^b
    var cnt = 0

    while (xor > 0) {
      val mask = (xor & 1)
      if ((xor & mask) == 1) {
        cnt += 1
      }

      xor = (xor >> 1)
    }

    cnt
  }


  def main(args: Array[String]): Unit = {
    val nums = Array(4, 14, 4, 14)
    totalHammingDistance(nums)
  }
}
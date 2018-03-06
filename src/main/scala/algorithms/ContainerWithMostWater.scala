package algorithms

object ContainerWithMostWater {
  def maxArea(height: Array[Int]): Int = {
    var i = 0
    var j = height.length - 1

    var area = 0
    while (i < j) {
      val w = (j - i)
      val h = Math.min(height(i), height(j))
      area = Math.max(area, w*h)

      if (height(i) > height(j)) {
        j -= 1
      } else {
        i += 1
      }
    }
    area
  }

  def main(args: Array[String]): Unit = {
    val height = Array(2,3,2,5,0,1)
    val area = maxArea(height)
    println(area)
  }
}

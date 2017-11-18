package algorithms

object ConstructTheRectangle {

  def constructRectangle(area: Int): Array[Int] = {
    val sqrt = math.sqrt(area).toInt
    val dim = Array.ofDim[Int](2)
    for (w <- 1 to sqrt) {
      if (area % w == 0) {
        dim(0) = area/w
        dim(1) = w
      }
    }

    dim
  }

  def main(args: Array[String]): Unit = {
    val dim = constructRectangle(1)
    println(dim.deep.mkString(", "))
  }
}

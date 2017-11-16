package algorithms

object ReshapeTheMatrix {

  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    val inputRow = nums.length
    val inputCol = nums(0).length

    if (r*c != inputRow*inputCol) {
      return nums
    }

    val reshaped = Array.ofDim[Int](r, c)
    var row = 0
    var col = 0
    for (i <- 0 until inputRow) {
      for (j <- 0 until inputCol) {
        reshaped(row)(col) = nums(i)(j)
        if (col == c-1) {
          col = 0
          row += 1
        } else {
          col += 1
        }
      }
    }

    reshaped
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(
      Array(1,2,3,4),
      Array(5,6,7,8),
      Array(9,10,11,12)
    )

    val reshaped = matrixReshape(nums, 2, 6)
    println(reshaped.deep.mkString("\n"))
  }

}

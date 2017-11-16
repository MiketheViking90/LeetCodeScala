package algorithms

object MaxDifference extends App {

  def getMaxDifference(nums: Array[Int]) = {
    val n = nums.length
    var maxAfter = nums(n-1)

    var maxDiff = 0
    for (i <- n-2 to 0 by -1) {
      val curVal = nums(i)

      if (curVal < maxAfter) {
        val curDiff = (maxAfter - curVal)
        if (curDiff > maxDiff) {
          maxDiff = curDiff
        }
      } else if (curVal > maxAfter) {
        maxAfter = curVal
      } else {}
    }

    print(maxDiff)
  }

  val nums = Array(7, 9, 5, 6, 3, 2)
  getMaxDifference(nums)
}

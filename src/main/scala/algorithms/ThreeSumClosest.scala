package algorithms

object ThreeSumClosest {

  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val len = nums.length
    var minDist = Int.MaxValue
    var minDistSum = 0
    val numsSorted = nums.sorted

    for (i <- 0 to len-2) {
      val a = numsSorted(i)
      var j = i+1
      var k = len-1

      while (j < k) {
        val b = numsSorted(j)
        val c = numsSorted(k)

        println(a + ", " + b + ", " + c)
        val sum = a+b+c
        val diff = getDist(sum, target)
        if (minDist > Math.abs(diff)) {
          minDistSum = sum
          minDist = Math.min(diff, minDist)
        }

        if (sum > target) {
          k -= 1
        } else {
          j += 1
        }
      }
    }

    minDistSum
  }

  def getDist(sum: Int, target: Int):Int = {
    if (sum > target) {
      return sum - target
    } else {
      return target - sum
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(-3,0,1,2)
    val diff = threeSumClosest(nums, 1)
    println(diff)
  }
}

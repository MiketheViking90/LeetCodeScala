package algorithms

object MinSizeSubarraySum {

  def minSubArrayLen(nums: Array[Int], s: Int): Int = {
    val len = nums.length;

    for (subLen <- 0 until len) {
      for (i <- 0 until (len-subLen)) {
        val sum = sumNums(nums, i, i+subLen)
        if (sum >= s) {
          return subLen
        }
      }
    }
    0
  }

  def sumNums(nums: Array[Int], a: Int, b: Int): Int = {
    var sum = 0
    for (i <- a to b) {
      sum += nums(i)
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(2,3,1,2,4,3)
    val s = 7

    val len = minSubArrayLen(nums, 7)
    println(len)
  }

}

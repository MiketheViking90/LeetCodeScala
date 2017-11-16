package algorithms

object LongestContiguousSum extends App {

  def getSum(nums: Array[Int]) : Int = {
    var curSum = 0
    var maxSum = 0

    for(i <- nums) {
      curSum += i

      if (curSum < 0) {
        curSum = 0
      }

      if (curSum > maxSum) {
        maxSum = curSum
      }
    }

    maxSum
  }

  val nums = Array(1, 3, -5, 7, 12, -4, 1)
  val sum = getSum(nums)
  print(sum)

}

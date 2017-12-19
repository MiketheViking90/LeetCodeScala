package algorithms

object TwoSumII {

  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var i = 0
    var j = numbers.length-1

    while (i < j) {
      val sum = numbers(i) + numbers(j)
      if (sum == target) {
        return Array(i+1, j+1)
      } else if (sum < target) {
        i+=1
      } else {
        j-=1
      }
    }
    null
  }

}

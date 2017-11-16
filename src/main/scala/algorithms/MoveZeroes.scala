package algorithms

object MoveZeroes {

  def moveZeroes(nums: Array[Int]): Unit = {
    var a = 0
    var b = 1

    while (b < nums.length) {
      if (nums(a) == 0 && nums(b) != 0) {
        swap(nums, a, b)
      }

      if (b < nums.length && nums(b) == 0) {
        b+=1
      }
      if (a < nums.length && nums(a) != 0) {
        a+=1
      }
    }
  }

  def swap(nums: Array[Int], a: Int, b: Int) {
    val tmp = nums(a)
    nums(a) = nums(b)
    nums(b) = tmp
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(0, 1, 0, 3, 12)
    moveZeroes(nums)
  }

}

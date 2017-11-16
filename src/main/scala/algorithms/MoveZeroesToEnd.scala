package algorithms

object MoveZeroesToEnd extends App {

  def moveZeroes(nums: Array[Int]) {
    var i=0
    var j=nums.length - 1
    while (nums(j) == 0) {
      j-=1
    }

    while (j >= i) {
      if (nums(i) != 0) {
        i+=1
      } else {
        nums(i) = nums(j)
        nums(j) = 0

        while (nums(j) == 0) {
          j-=1
        }
      }
    }
  }

  val nums = Array(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0)
  moveZeroes(nums)
  print(nums.mkString(", "))
}

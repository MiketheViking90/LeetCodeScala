package algorithms

object RemoveDuplicatesSortedArray {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums == null) {
      return 0
    }

    val n = nums.length
    if (n == 0 || n == 1) {
      return 1
    }

    var i = 0
    var j = 1
    var cnt = 1
    while (j < n) {
      val ni = nums(i)
      val nj = nums(j)
      if (ni == nj) {
        j += 1
      } else {
        j = getNext(i, j, nums)
        if (j == -1) {
          return cnt
        }

        cnt += 1
        swap(i+1, j, nums)
        i += 1
        j += 1
      }
    }
    cnt
  }

  def getNext(i: Int, j: Int, nums: Array[Int]): Int = {
    val ni = nums(i)
    var k = j
    while (k < nums.length && nums(k) == ni) {
      k += 1
    }
    if (k != nums.length) {
      return k
    }

    -1
  }

  def swap(i: Int, j: Int, nums: Array[Int]): Unit = {
    val c = nums(i)
    nums(i) = nums(j)
    nums(j) = c
  }


  def main(args: Array[String]): Unit = {
    val nums = Array(1,1,1,2,2,2,3,3,3)
    val cnt = removeDuplicates(nums)
    println(cnt)
    println(nums.mkString(", "))
  }

}

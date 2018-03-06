package algorithms

object RemoveElement {

  def swap(i: Int, j: Int, nums: Array[Int]): Unit = {
    val c = nums(i)
    nums(i) = nums(j)
    nums(j) = c
  }


  def getNext(i: Int, v: Int, nums: Array[Int]): Int = {
    var k = i
    while (k < nums.length && nums(k) == v) {
      k += 1
    }

    if (k == nums.length) {
      -1
    } else {
      k
    }
  }

  def removeElement(nums: Array[Int], v: Int): Int = {
    if (nums == null) {
      return 0
    }

    val n = nums.length
    if (n == 0 || n == 1) {
      return n
    }

    var i = 0
    var j = 1
    var cnt = 0

    while (j < n && i < n) {
      val ni = nums(i)
      val nj = nums(j)

      if (ni != v && nj != v) {
        i += 1
        j += 1
      } else if (i != v && j == v) {
        i = getNext(j, v, nums)

        if (i == -1) {
          return cnt
        }

        cnt += 1
        swap(i, j, nums)
        j = getNext(j, v, nums)
      } else if (i == v && j != v) {
        j = getNext(j, v, nums)
        swap(i, j, nums)
        i = j
        j += 1
        cnt += 1
      } else {
        j += 1
      }
    }

    cnt
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(3,3,3,3)
    val k = 3

    val n = removeElement(nums, k)
    println(n)
    println(nums.mkString(", "))
  }
}

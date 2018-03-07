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
    if (n == 0) {
      return n
    }
    if (n == 1) {
      if (nums(0) == v) {
        return 0
      } else {
        return 1
      }
    }


    var i = 0
    var j = 1
    var cnt = 0

    while (j < n && i < n) {
      val ni = nums(i)
      val nj = nums(j)

      if (ni != v && nj != v) {
        cnt += 2

        i += 2
        j += 2
      } else if (ni != v && nj == v) {
        cnt += 1
        i = getNext(j, v, nums)

        if (i == -1) {
          return cnt
        }
        swap(i, j, nums)
        j = getNext(j, v, nums)
      } else if (ni == v && nj != v) {
        cnt += 1
        j = getNext(j, v, nums)
        if (j == -1) {
          return cnt
        }
        swap(i, j, nums)
        i = j
        j += 1
      } else {
        j += 1
      }
    }

    cnt
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(3,4)
    val k = 5

    val n = removeElement(nums, k)
    println(n)
    println(nums.mkString(", "))
  }
}

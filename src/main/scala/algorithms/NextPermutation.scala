package algorithms

import scala.collection.mutable

object NextPermutation {

  def nextPermutation(nums: Array[Int]): Unit = {
    if (!isValid(nums)) {
      nums.sorted((x: Int, y: Int) => y-x)
      println(nums.mkString(", "))
      return
    }

    val len = nums.length
    for (i <- 0 until len-1) {
      for (j <- i+1 until len) {
        if (nums(j) > nums(i)) {
          swap(i, j, nums)
          return
        }
      }
    }
  }

  def isValid(nums: Array[Int]): Boolean = {
    for (i <- 1 until nums.length) {
      if (nums(i) > nums(i-1)) {
        return true
      }
    }
    false
  }

  def swap(i: Int, j: Int, nums: Array[Int]) = {
    val c = nums(i)
    nums(i) = nums(j)
    nums(j) = c
  }

  def main(args: Array[String]): Unit = {
//    val nums = Array(1,3,2,1,2,4,5)
    val nums = Array(1,2,3,4)
    nextPermutation(nums)
    println(nums.mkString(", "))

    var numSet = new mutable.HashSet[Int]
    numSet += 1
    numSet += 2
    numSet += 3
  }

}

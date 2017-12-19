package algorithms

import scala.collection.mutable.ArrayBuffer

object Permutations {

  def permute(nums: Array[Int], permutations: ArrayBuffer[List[Int]], idx: Int) {
    val n = nums.length
    permutations+=nums.toList

    if (idx == n-1) {
      return
    }

    for (i <- idx+1 until n) {
      val numsCpy = nums.clone()

      val tmp = numsCpy(i)
      numsCpy(i) = numsCpy(idx)
      numsCpy(idx) = tmp

      println(nums(idx) + ": " + numsCpy.mkString(", "))

      permute(numsCpy, permutations, idx+1)
    }

  }

  def permute(nums: Array[Int]): List[List[Int]] = {
    val permutations = new ArrayBuffer[List[Int]]()
    permute(nums, permutations, 0)
    permutations.toList
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3)
    val perms = permute(nums)

    for (perm <- perms) {
      println("\t" + perm.mkString(", "))
    }
  }

}

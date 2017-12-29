package algorithms

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object ThreeSum {

  def threeSum(nums: List[Int]): Set[List[Int]] = {
    val res = new mutable.HashSet[List[Int]]
    val sorted = nums.sorted

    val sumToAddends = new mutable.HashMap[Int, ArrayBuffer[List[Int]]]
    for (i <- 0 until sorted.length - 1) {
      val a = nums(i)
      for (j <- i+1 until sorted.length) {
        val b = nums(j)
        val sum = a + b
        var addends = sumToAddends.getOrElse(sum, new ArrayBuffer[List[Int]]())
        addends += List(a, b)
        sumToAddends.put(sum, addends)
      }
    }

    for (n <- nums) {
      val neg = -n
      if (sumToAddends.contains(neg)) {
        val addends = sumToAddends(neg)
        for (addend <- addends) {
          val triple = n::addend
          res.add(triple.sorted)
        }
      }
    }
    res.toSet
  }

  def main(args: Array[String]): Unit = {
    val ts = ThreeSum

    val nums = List(-1, 0, 1, 2, -1, -4)
    val res = ts.threeSum(nums)
    println(res.mkString(", "))
  }
}

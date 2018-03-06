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

  def tSum(nums: List[Int]): List[List[Int]] = {
    val numsSorted = nums.sorted
    val len = nums.length
    val map2 = new mutable.HashMap[Int, mutable.Set[List[Int]]]()

    for (i <- 0 until len-1) {
      val n1 = numsSorted(i)
      for (j <- i+1 until len) {
        val n2 = numsSorted(j)
        var curDouble = List(n1, n2)
        val sum = n1+n2

        var doubles = map2.getOrElse(sum, new mutable.HashSet[List[Int]])
        doubles += curDouble
        map2.put(sum, doubles)
      }
    }

    val triples = new mutable.HashSet[List[Int]]()
    for (n3 <- numsSorted) {
      if (map2.contains(-n3)) {
        val doubles = map2.get(-n3).get
        for (double <- doubles) {
          val triple = (n3::double)
          triples.add(triple)
        }
      }
    }

    triples.toList
  }

  def main(args: Array[String]): Unit = {
    val ts = ThreeSum

    val nums = List(-1, 0, 1, 2, -1, -4)
    val res = ts.tSum(nums)
    println(res.mkString(", "))
  }
}

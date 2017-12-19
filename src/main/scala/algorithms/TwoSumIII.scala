package algorithms

import scala.collection.mutable

object TwoSumIII {

  val nums = new mutable.HashSet[Int]
  val sums = new mutable.HashSet[Int]

  def add(n: Int) {
    if (nums.nonEmpty) {
      for (i <- nums) {
        sums += (i+n)
      }
    }

    nums+=n
  }

  def find(sum: Int): Boolean = {
    sums.contains(sum)
  }

  def main(args: Array[String]): Unit = {
    val ts = TwoSumIII

    ts.add(1)
    ts.add(2)
    ts.add(3)

    println(ts.find(1))
    println(ts.find(2))
    println(ts.find(3))
    println(ts.find(4))
    println(ts.find(5))
    println(ts.find(6))
  }
}

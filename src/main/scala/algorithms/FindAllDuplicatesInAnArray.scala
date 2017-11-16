package algorithms

import scala.collection.mutable.ArrayBuffer

object FindAllDuplicatesInAnArray {

  def findDuplicates(nums: Array[Int]): List[Int] = {
    val dups = new ArrayBuffer[Int]
    val len = nums.length

    if (len < 2) {
      return dups.toList
    }

    for (i <- 0 until len) {
      var n = nums(i)
      if (n < 0) {
        n = -n
      }
      println(n)
      val isDuplicate = nums(n-1)

      if (isDuplicate > 0) {
        nums(isDuplicate) = -nums(isDuplicate)
      } else {
        dups += n
      }
    }

    dups.toList
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1)
    val dups = findDuplicates(nums)
    print(dups)
  }

}

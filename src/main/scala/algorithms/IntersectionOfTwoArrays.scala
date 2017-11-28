package algorithms

import scala.collection.mutable

object IntersectionOfTwoArrays {

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val aSet = new mutable.HashSet[Int]
    for (num <- nums1) {
      aSet.add(num)
    }

    val intersect = new mutable.HashSet[Int]
    for (num <- nums2) {
      if (aSet.contains(num)) {
        intersect.add(num)
      }
    }

    intersect.toArray
  }

}

package algorithms

import domain.TreeNode

object MinAbsoluteDifferenceInBST {

  var prev: TreeNode = _
  var min: Int = Int.MaxValue

//  def getMinimumDifference(root: TreeNode): Int = {
//    if (root == null) {
//      return min
//    }
//
//    getMinimumDifference(root.left)
//
//    if (prev != null) {
//      println(root.value + ", " + prev.value + ", " + min)
//      min = math.min(min, root.value - prev.value)
//    }
//    prev = root
//    getMinimumDifference(root.right)
//
//    min
//  }

  def getMinDiff(root: TreeNode, prev: Int): Int = {
    if (root == null) {
      return Int.MaxValue
    }

    val curDiff = math.abs(prev - root.value)
    val lMin = getMinDiff(root.left, math.min(root.value, prev))
    val rMin = getMinDiff(root.right, math.max(root.value, prev))

    math.min(curDiff, math.min(lMin, rMin))
  }

  def getMinimumDifference(root: TreeNode): Int = {
    math.min(getMinDiff(root.left, root.value), getMinDiff(root.right, root.value))
  }

  def main(args: Array[String]): Unit = {
    val root = TreeNode.makeBST()
    val n = getMinimumDifference(root)
    println(n)
  }
}

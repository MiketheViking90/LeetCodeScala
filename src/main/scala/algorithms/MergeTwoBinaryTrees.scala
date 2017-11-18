package algorithms

import domain.TreeNode

object MergeTwoBinaryTrees {

  def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
    if (t1 == null && t2 == null) {
      return null
    } else if (t1 == null) {
      mergeTrees(null, t2.left)
      mergeTrees(null, t2.right)
      return t2
    } else if (t2 == null) {
      mergeTrees(t1.left, null)
      mergeTrees(t1.right, null)
      return t1
    } else {
      t1.value += t2.value
      mergeTrees(t1.left, t2.left)
      mergeTrees(t1.right, t2.right)
    }

    t1
  }

  def main(args: Array[String]): Unit = {
    var t1 = TreeNode.makeTree()
    var t2 = TreeNode.makeBST()

    t1 = mergeTrees(t1, t2)
    TreeNode.printTree(t1)
  }

}

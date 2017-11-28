package algorithms

import domain.TreeNode

object SumOfLeftLeaves {

  def sumOfLeftLeaves(root: TreeNode): Int = {
    sumLeaves(root, false)
  }

  def sumLeaves(root: TreeNode, isLeft: Boolean): Int = {
    if (root == null) {
      return 0
    } else if (root.left == null && root.right == null && isLeft) {
      return root.value
    }

    sumLeaves(root.left, true) + sumLeaves(root.right, false)
  }

}

package algorithms

import domain.TreeNode

object SameTree {

  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) {
      return true
    }
    if (p != null ^ q != null) {
      return false
    }

    val isLeftSame = isSameTree(p.left, q.left)
    val isRightSame = isSameTree(p.right, q.right)

    return isLeftSame && isRightSame && (p.value == q.value)
  }

}

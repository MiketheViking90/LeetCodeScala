package algorithms

import domain.TreeNode

import scala.collection.mutable

object TwoSumBST {

  def findTarget(root: TreeNode, k: Int): Boolean = {
    val set = new mutable.HashSet[Integer]();
    dfs(root, set, k)
  }

  def dfs(root: TreeNode, set: mutable.Set[Integer], k: Int): Boolean = {
    if (root == null) {
      return false
    }

    val data = root.value
    if (set.contains(k-data)) {
      return true
    }

    set.add(data)
    dfs(root.left, set, k) || dfs(root.right, set, k)
  }

}

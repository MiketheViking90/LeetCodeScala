package algorithms

import domain.TreeNode

import scala.collection.mutable

object AddOneRowToTree {

  def addOneRow(root: TreeNode, v: Int, d: Int): TreeNode = {
    if (d == 1) {
      val newRoot = new TreeNode(v)
      newRoot.left = root
      return newRoot
    }

    val q = new mutable.Queue[TreeNode]
    q.enqueue(root)

    var depth = 0
    while (q.nonEmpty) {
      val width = q.size

      for (_ <- 0 until width) {
        val visit = q.dequeue()

        val l = visit.left
        val r = visit.right
        if (l != null) q.enqueue(l)
        if (r != null) q.enqueue(r)

        if (depth == d) {
          val newL = new TreeNode(v)
          val newR = new TreeNode(v)
          newL.left = l
          newR.right = r

          visit.left = newL
          visit.right = newR
        }
      }
      depth += 1
    }

    root
  }

  def main(args: Array[String]): Unit = {
    var root = TreeNode.makeBST()
    root = addOneRow(root, 12, 2)
    TreeNode.printTree(root)
  }
}

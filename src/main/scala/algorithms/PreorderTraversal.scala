package algorithms

import domain.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object PreorderTraversal {

  def preorderTraversal(root: TreeNode): List[Int] = {
    val trav = new ArrayBuffer[Int]

    traverse_I(root, trav)
    trav.toList
  }

  def traverse_I(root: TreeNode, trav: ArrayBuffer[Int]) {
    val stack = new mutable.ArrayStack[TreeNode]()
    if (root != null) stack.push(root)

    while (stack.nonEmpty) {
      val node = stack.pop()
      trav+=node.value

      if (node.right != null) stack.push(node.right)
      if (node.left != null) stack.push(node.left)
    }
  }

  def traverse_R(root: TreeNode, trav: ArrayBuffer[Int]) {
    if (root == null) {
      return
    }

    trav+= root.value
    traverse_R(root.left, trav)
    traverse_R(root.right, trav)
  }

  def main(args: Array[String]): Unit = {
    val root = TreeNode.makeTree()
    TreeNode.printTree(root)

    val trav = preorderTraversal(root)
    val travStr = trav.mkString(", ")
    println(travStr)
  }

}

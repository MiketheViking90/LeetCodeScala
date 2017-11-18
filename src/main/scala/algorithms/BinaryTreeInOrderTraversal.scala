package algorithms

import domain.TreeNode

import scala.collection.mutable.ListBuffer

object BinaryTreeInOrderTraversal {

  def inorderTraversal(root: TreeNode): List[Int] = {
    val traversal = new ListBuffer[Int]()
    traverse(root, traversal)
    traversal.toList
  }

  def traverse(root: TreeNode, traversal: ListBuffer[Int]) {
    if (root == null) {
      return
    }

    traverse(root.left, traversal)
    traversal += root.value
    traverse(root.right, traversal)
  }

  def main(args: Array[String]): Unit = {
    val root = TreeNode.makeBST()
    val trav = inorderTraversal(root)
    println(trav.mkString(", "))
  }

}

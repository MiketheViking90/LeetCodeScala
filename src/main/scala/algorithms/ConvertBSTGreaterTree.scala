package algorithms

import domain.TreeNode

object ConvertBSTGreaterTree {

  var sum = 0

  def convertBST(root: TreeNode): TreeNode = {
    convert(root)
    root
  }

  def convert(root: TreeNode): Unit  = {
    if (root == null) {
      return
    }

    convert(root.right)
    val value = root.value
    root.value += sum
    sum += value
    convert(root.left)
  }

  def main(args: Array[String]): Unit = {
    //val root = TreeNode.makeBST()

    val root = new TreeNode(2)
    root.left = new TreeNode(1)
    root.right = new TreeNode(3)

    TreeNode.printTree(root)

    convertBST(root)

    TreeNode.printTree(root)
  }

}

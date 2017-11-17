package domain

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class TreeNode(var value: Int = 0, var left: TreeNode = null, var right: TreeNode = null) {}

object TreeNode {

  def printTree(root: TreeNode) {
    val levelMap = new mutable.TreeMap[Integer, ArrayBuffer[Int]]()
    fillMap(root, 0, levelMap)

    for (entry <- levelMap) {
      print(entry._1 + ": ")
      println(entry._2)
    }
  }

  def makeBST(): TreeNode = {
    val node5 = new TreeNode(5)
    val node3 = new TreeNode(3)
    val node4 = new TreeNode(4)
    val node12 = new TreeNode(12)
    val node7 = new TreeNode(7)
    val node16 = new TreeNode(16)

    node5.left = node3
    node5.right = node12

    node3.right = node4

    node12.left = node7
    node12.right = node16

    node5
  }

  def makeTree(): TreeNode = {
    val node1 = new TreeNode(1)
    val node2 = new TreeNode(2)
    val node3 = new TreeNode(3)
    val node4 = new TreeNode(4)
    val node5 = new TreeNode(5)
    val node6 = new TreeNode(6)


    node1.left = node2
    node1.right = node3

    node2.left = node4
    node2.right = node5

    node3.left = node6

    node1
  }

  private def fillMap(root: TreeNode, lvl: Int, levelMap: mutable.Map[Integer, ArrayBuffer[Int]]): Unit = {
    if (root == null) {
      return
    }

    var curLevel = levelMap.getOrElse(lvl, new ArrayBuffer[Int])
    curLevel.+=(root.value)
    levelMap.put(lvl, curLevel)

    fillMap(root.left, lvl+1, levelMap)
    fillMap(root.right, lvl+1, levelMap)
  }

  def main(args: Array[String]): Unit = {
    val root = TreeNode.makeTree()
    TreeNode.printTree(root)
  }

}


package domain

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class TreeNode(val data: Int = 0, var left: TreeNode = null, var right: TreeNode = null) {}

object TreeNode {

  def printTree(root: TreeNode) {
    val levelMap = new mutable.HashMap[Integer, ArrayBuffer[Integer]]()
    fillMap(root, 0, levelMap)
  }

  def fillMap(root: TreeNode, lvl: Int, levelMap: mutable.HashMap[Integer, ArrayBuffer[Integer]]): Unit = {
    if (root == null) {
      return
    }

    var curLevel = levelMap.getOrElse(lvl, new ArrayBuffer[Int])
    curLevel+=(123)
  }

}


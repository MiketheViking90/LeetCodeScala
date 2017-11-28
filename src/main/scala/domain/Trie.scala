package domain

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Trie {

  val root = new TrieNode()

  def add(word: String) = {
    val len = word.length
    var node = root
    for (i <- 0 until len) {
      val c = word.charAt(i)
      val children = node.children

      if (children.contains(c)) {
        node = children(c)
      } else {
        node = new TrieNode(c)
        children.put(c, node)
      }
      if (i == len-1) {
        node.isLeaf = true
      }
    }
  }

  def search(word: String): Boolean = {
    var node = root
    for (c <- word.toCharArray) {
      val children = node.children
      if (!children.contains(c)) {
        return false
      }

      node = children(c)
    }

    if (node.isLeaf) {
      true
    } else {
      false
    }
  }

  def hasPrefix(prefix: String): Seq[String] = {
    val hasPrefix = new ListBuffer[String]

    var node = root
    for (c <- prefix.toCharArray) {
      val children = node.children
      if (!children.contains(c)) {
        return hasPrefix
      }

      node = children(c)
    }

    val toVisit = new mutable.Stack[TrieNode]
    toVisit.push(node)
    var suffix = ""
    while (toVisit.nonEmpty) {
      node = toVisit.pop()
      suffix += node.value
      if (node.isLeaf) {
        hasPrefix += (prefix + suffix)
        suffix = ""
      }

      toVisit.pushAll(node.children.values)
    }

    hasPrefix
  }
}

object Trie {

  def printTrie(trie: Trie) = {
    val queue = new mutable.Queue[TrieNode]
    queue.enqueue(trie.root)
    var level = 0

    while (queue.nonEmpty) {
      println(level)
      val len = queue.length
      for (_ <- 0 until len) {
        val node = queue.dequeue()
        val children = node.children
        if (children.nonEmpty) {
          println("\t" + children.keySet)
        }

        for (entry <- children) {
          queue.enqueue(entry._2)
        }
      }
      level += 1
    }
  }

  def main(args: Array[String]): Unit = {
    val root = new Trie()
    root.add("cat")
    root.add("cod")
    root.add("cate")
    root.add("cata")
    root.add("catz")

    val matches = root.hasPrefix("ca")
    println(matches)
  }
}

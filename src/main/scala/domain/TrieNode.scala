package domain

import scala.collection.mutable

class TrieNode(val value: Char) {

  def this() {
    this(' ')
  }

  val children = new mutable.TreeMap[Char, TrieNode]
  var isLeaf = false
}
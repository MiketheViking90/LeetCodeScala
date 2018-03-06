package algorithms

import domain.ListNode

object LinkedListRandomNode {

  def getLength(head: ListNode): Int = {
    var len = 0
    var node = head
    while (node != null) {
      len += 1
      node = node.next
    }
    len
  }

  def get(head: ListNode, idx: Int): Int = {
    var i = idx
    var node = head
    while (i > 0) {
      i -= 1
      node = node.next
    }
    node.x
  }

  def getRandom(head: ListNode): Int = {
    val len = getLength(head)
    val idx = (math.random() * len).toInt
    get(head, idx)
  }

}

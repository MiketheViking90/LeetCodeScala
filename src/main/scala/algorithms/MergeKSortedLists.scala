package algorithms

import domain.ListNode

import scala.collection.mutable

object MergeKSortedLists {

  val listNodeOrdering = new Ordering[ListNode] {
    override def compare(node1: ListNode, node2: ListNode): Int = {
      node1.x - node2.x
    }
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if (lists == null || lists.isEmpty) {
      return null;
    }

    val pq = mutable.PriorityQueue.empty[ListNode](listNodeOrdering)
    for (node <- lists) {if (node != null) {
      pq.enqueue(node)
    }

    }

    var head = null:ListNode
    var tail  = null:ListNode
    while (!pq.isEmpty) {
      val node = pq.dequeue()

      if (head == null) {
        head = node
        tail = head
      } else {
        tail.next = node
        tail = tail.next
      }

      if (node.next != null) {
        pq.enqueue(node.next)
      }
    }

    head
  }

}

package algorithms

import domain.ListNode

object ReverseLinkedList {

  def reverseList(head: ListNode): ListNode = {
    var prev = head
    var cur = head.next
    var next = head.next
    head.next = null

    while (next != null) {
      next = cur.next
      cur.next = prev
      prev = cur
      cur = next
    }

    prev
  }

  def main(args: Array[String]): Unit = {
    var head = ListNode.makeList()
    ListNode.printList(head)

    head = reverseList(head)

    ListNode.printList(head)
  }

}

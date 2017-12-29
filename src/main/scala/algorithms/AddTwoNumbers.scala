package algorithms

import domain.ListNode

object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var h1 = l1
    var h2 = l2

    var head = null:ListNode
    var tail = null:ListNode
    var carry = false

    while (h1 != null || h2 != null) {
      var value = 0

      if (h1 != null) value += h1.value
      if (h2 != null) value += h2.value

      if (carry) {
        value += 1
        carry = false
      }

      if (value >= 10) {
        carry = true
        value -= 10
      }
      val node = new ListNode(value)
      if (head == null) {
        head = node
        tail = node
      } else {
        tail.next = node
        tail = node
      }

      if (h1 != null) h1 = h1.next
      if (h2 != null) h2 = h2.next
    }

    if (carry) {
      tail.next = new ListNode(1)
    }
    head
  }

  def main(args: Array[String]): Unit = {
    val l1 = ListNode.makeList()
    val l2 = ListNode.makeList()
    ListNode.append(l2, 4)
    ListNode.append(l2, 10)
    ListNode.append(l2, 4)
    ListNode.append(l2, 10)

    val sum = addTwoNumbers(l1, l2)
    ListNode.printList(sum)
  }
}

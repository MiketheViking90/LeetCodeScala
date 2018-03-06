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

      if (h1 != null) value += h1.x
      if (h2 != null) value += h2.x

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

  def add2Numbers(l1: ListNode, l2: ListNode): ListNode = {
    var l1Head = l1
    var l2Head = l2
    if (l1 == null) {
      return l2
    }

    if (l2 == null) {
      return l1
    }

    var head = null:ListNode
    var cur = head
    var carry = 0

    while (l1Head != null && l2Head != null) {
      var digit = l1Head.x + l2Head.x + carry
      carry = 0
      if (digit >= 10) {
        digit -= 10
        carry = 1
      }

      if (head == null) {
        head = new ListNode(digit)
        cur = head
      } else {
        cur.next = new ListNode(digit)
        cur = cur.next
      }

      l1Head = l1Head.next
      l2Head = l2Head.next
    }

    var tail = null:ListNode
    if (l1Head != null) {
      tail = l1Head
    } else if (l2Head != null) {
      tail = l2Head
    }

    appendTail(cur, tail, carry)

    head
  }

  def appendTail(cur: ListNode, tail: ListNode, carry: Int): Unit = {
    var isCarry = carry
    var curNode = cur
    var tailNode = tail

    while (tailNode != null) {
      var digit = tailNode.x + isCarry
      isCarry = 0
      if (digit >= 10) {
        digit -= 10
        isCarry = 1
      }

      curNode.next = new ListNode(digit)
      curNode = curNode.next
      tailNode = tailNode.next
    }

    if (isCarry == 1) {
      curNode.next = new ListNode(1)
    }
  }

  def main(args: Array[String]): Unit = {
//    val l1 = ListNode.makeList()
//    val l2 = ListNode.makeList()
//    ListNode.append(l2, 9)
//    ListNode.append(l2, 9)
//    ListNode.append(l2, 9)
//    ListNode.append(l2, 9)
    val l1 = new ListNode(2)
    ListNode.append(l1, 4)
    ListNode.append(l1, 3)

    val l2 = new ListNode(5)
    ListNode.append(l2, 6)
    ListNode.append(l2, 4)

    val sum = add2Numbers(l1, l2)
    ListNode.printList(sum)
  }
}

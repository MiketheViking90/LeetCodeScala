package domain

class ListNode(var x: Int, var next: ListNode = null) {}

object ListNode {

  def makeList(): ListNode = {
    val l1 = new ListNode(1)
    val l2 = new ListNode(2)
    l1.next = l2
    val l3 = new ListNode(3)
    l2.next = l3
    val l4 = new ListNode(4)
    l3.next = l4
    val l5 = new ListNode(5)
    l4.next = l5

    l1
  }

  def printList(head: ListNode) {
    var node = head
    var toString = ""
    while (node != null) {
      toString += (node.x + ">")
      node = node.next
    }

    println(toString)
  }

  def append(head: ListNode, n: Int): ListNode = {
    var node = head
    while (node.next != null) {
      node = node.next
    }
    node.next = new ListNode(n)
    head
  }

  def main(args: Array[String]): Unit = {
    val node = makeList()
    printList(node)
  }
}

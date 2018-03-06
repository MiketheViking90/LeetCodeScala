package algorithms

import scala.collection.mutable

object ValidParentheses {

  def isValid(s: String): Boolean = {
    if (s == null || s.length % 2 != 0) {
      return false
    }

    val opens = mutable.Stack[Char]()
    for (c <- s) {
      if (isOpen(c)) {
        opens.push(c)
      } else {
        if (opens.isEmpty) {
          return false
        }
        val top = opens.pop()
        if (!doesMatch(top, c)) {
          return false
        }
      }
    }

    return opens.isEmpty
  }

  def isOpen(c: Char): Boolean = {
    return (c == '(' || c == '[' || c == '{')
  }

  def doesMatch(open: Char, close: Char): Boolean = {
    if (close == ')') {
      return open == '('
    } else if (close == ']') {
      return open == '['
    } else if (close == '}') {
      return open == '{'
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val b = isValid("()")
    println(b)
  }
}

package algorithms

import scala.collection.mutable.ArrayBuffer

object GenerateParentheses {

  def generateParenthesis(n: Int): List[String] = {
    val parens = new ArrayBuffer[String]
    genParentheses(n-1, n, "(", parens)
    parens.toList
  }

  def genParentheses(l: Int, r: Int, curParen: String, parens: ArrayBuffer[String]): Unit = {
    if (l == 0 && r == 0) {
      parens += curParen
      return
    }

    if (l > 0) {
      genParentheses(l-1, r, curParen + "(", parens)
    }

    if (r > l) {
      genParentheses(l, r-1, curParen + ")", parens)
    }
  }

  def genParen(n: Int): List[String] = {
    val parens = ArrayBuffer[String]()
    getParens(n-1, n, parens, "(")

    parens.toList
  }

  def getParens(l: Int, r: Int, parens: ArrayBuffer[String], str: String): Unit = {
    if (l == 0 && r == 0) {
      parens += str
      return
    }

    if (l > 0) {
      getParens(l-1, r, parens, str + "(")
    }

    if (r > l) {
      getParens(l, r-1, parens, str + ")")
    }
  }


  def main(args: Array[String]): Unit = {
    val parens = genParen(3)
    println(parens.mkString(", "))
  }

}

package algorithms

import scala.collection.mutable.ArrayBuffer

object LetterCombos {

  def letterCombinations(digits: String): List[String] = {
    if (digits == null || digits == "") {
      return List[String]()
    }
    val dict = Array("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    val combos = new ArrayBuffer[String]

    getCombos(combos, digits, "", dict)

    combos.toList
  }

  def getCombos(combos: ArrayBuffer[String], digits: String, curString: String, dict: Array[String]): Unit = {
    if (digits.length == 0) {
      combos += curString
      return
    }

    val digit = digits.charAt(0).toInt - 48
    val letters = dict(digit)
    if (letters == "") {
      getCombos(combos, digits.substring(1), curString, dict)
    } else {
      for (c <- letters) {
        getCombos(combos, digits.substring(1), curString + c, dict)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val combos = letterCombinations("615")
    println(combos.mkString(", "))
  }

}

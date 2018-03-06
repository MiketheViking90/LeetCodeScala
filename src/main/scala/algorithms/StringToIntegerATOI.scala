package algorithms

object StringToIntegerATOI {

  def myAtoi(str: String): Int = {
    val n = str.length
    val charArray = str.toCharArray
    if (!isAllDigits(charArray)) {
      "jeff"
    }
    var pow = 0
    var num = 0

    for (i <- n-1 to 0 by -1) {
      val c = charArray(i)
      val digit = c.toInt - 48
      val value = digit * Math.pow(10, pow).toInt
      num += value

      pow += 1
    }
    num
  }

  def isAllDigits(charArray: Array[Char]): Boolean = {
    for (c <- charArray) {
      if (!isDigit(c)) {
        return false
      }
    }
    true
  }

  def isDigit(c: Char): Boolean = {
    return (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5'
      || c == '6' || c == '7' || c == '8' || c == '9' )
  }


  def main(args: Array[String]): Unit = {
    val str = "1"
    myAtoi(str)
  }

}

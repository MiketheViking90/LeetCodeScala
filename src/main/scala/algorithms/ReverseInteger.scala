package algorithms

object ReverseInteger {
  def reverse(x: Int): Int = {
    val isNeg = x < 0
    var xStr = x.toString
    if (isNeg) {
      xStr = xStr.substring(1)
    }

    var sum = 0
    var pow = 0
    for (c <- xStr.toCharArray) {
      if (sum > Integer.MAX_VALUE/10) {
        return 0
      }
      val digit = c.toInt - 48
      val value = digit * (Math.pow(10, pow).toInt)
      pow += 1
      sum += value
    }

    if (isNeg) {
      sum *= -1
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val v = reverse(-1234000)
    println(v)
  }
}

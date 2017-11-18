package algorithms

object ExcelSheetColumnNumber {

  def titleToNumber(s: String): Int = {
    var str = s
    var n = 0
    var power = 0
    while (str.length > 0) {
      val c = str.charAt(str.length - 1)
      str = str.substring(0, str.length - 1)

      var m = 1
      if (power > 0) {
        m = math.pow(26, power).toInt
      }
      val value = (c - 64) * m
      power += 1
      n += value
    }

    n
  }

  def main(args: Array[String]): Unit = {
    val num = titleToNumber("AAA")
    println(num)
  }
}

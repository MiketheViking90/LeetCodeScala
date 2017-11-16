package algorithms

object JumpingNumbers extends App {

  def isJumpingNumber(n: Int) : Boolean = {
    val nAsString = String.valueOf(n)
    for (i <- 1 until nAsString.length()) {
      val c0 = nAsString(i-1)
      val c1 = nAsString(i)

      if (Math.abs(c1 - c0) != 1) {
        return false;
      }
    }
    true
  }

  def getJumpingNumbersUntil(n: Int) {
    for(i <- 0 to n) {
      if (isJumpingNumber(i)) {
        println(i)
      }
    }
  }

  getJumpingNumbersUntil(50)

}

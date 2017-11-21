package algorithms

object MaxLengthPairChain {

  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    val sortedPairs = pairs.sortBy(_(1))

    var cnt = 0
    var end = Int.MinValue
    for (pair <- sortedPairs ) {
      if (pair(0) > end) {
        cnt += 1
        end = pair(1)
      }
    }

    cnt
  }

  def main(args: Array[String]): Unit = {
    val pairs = Array(Array(2,3), Array(1,2), Array(3,4))
    findLongestChain(pairs)
  }

}

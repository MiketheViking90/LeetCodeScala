package algorithms

object ProductOfArrayExceptSelf {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val len = nums.length

    var zeroCnt = 0
    var zeroIdx = -1
    for ( i <- 0 until len) {
      val n = nums(i)
      if (n == 0) {
        zeroCnt += 1
        zeroIdx = i
      }
    }

    if (zeroCnt > 1) {
      return new Array[Int](len)
    }

    var prod = 1
    for (n <- nums) {
      if (n != 0) {
        prod *= n
      }
    }

    if (zeroCnt == 1) {
      val res = new Array[Int](len)
      res(zeroIdx) = prod
      return res
    }

    val prods = new Array[Int](len)
    for (i <- 0 until len) {
      val n = nums(i)
      if (n != 0) {
        val curProd = prod / n
        prods(i) = curProd
      } else {
        prods(i) = prod
      }
    }

    prods
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1,2,3,4,0)
    val prods = productExceptSelf(nums)
    print(prods.deep.mkString(", "))
  }

}

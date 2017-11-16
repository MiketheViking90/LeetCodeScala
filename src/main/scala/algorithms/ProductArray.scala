package algorithms

object ProductArray extends App {

  def getProductArray(nums: Array[Int]) : Array[Int] = {
    val len = nums.length
    val prodArray = new Array[Int](len)

    var prod = 1;
    for (i <- nums) {
      prod*=i
    }

    for (i <- 0 until len) {
      prodArray(i) = (prod/nums(i))
    }
    prodArray
  }

  val nums = Array(1, 3, 4, 2, 84, 423)
  val prods = getProductArray(nums)

  print(prods.mkString(","))
}

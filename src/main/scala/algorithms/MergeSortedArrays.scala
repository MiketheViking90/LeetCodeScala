package algorithms

object MergeSortedArrays extends App {

  def merge(A: Array[Int], B: Array[Int]) {
    val len1 = A.length
    val len2 = B.length

    var i = len1 - len2 - 1
    var j = len2 - 1
    var k = len1 - 1

    while (k > i) {
      if (A(i) > B(j)) {
        A(k) = A(i)
        k -= 1
        i -= 1
      } else {
        A(k) = B(j)
        k -= 1
        j -= 1
      }
    }
  }

  val A = Array(1, 3, 5, 12, 0, 0, 0, 0)
  val B = Array(6, 10, 11, 24)

  merge(A, B)
  println(A.mkString(","))
}
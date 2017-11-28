package algorithms

object AssignCookies {

  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val gSort = g.sortWith(_>_)
    val sSort = s.sortWith(_>_)

    var i = 0
    var j = 0
    var cnt = 0
    while (i < gSort.length && j < sSort.length) {
      val gi = gSort(i)
      val sj = sSort(j)

      if (sj >= gi) {
        j += 1
        i += 1
        cnt += 1
      } else {
        i += 1
      }
    }
    cnt
  }

  def main(args: Array[String]): Unit = {
    val g = Array(3, 1, 2)
    val s = Array(2, 2)

    val cnt = findContentChildren(g, s)
    println(cnt)
  }

}

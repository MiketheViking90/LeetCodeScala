package designpatterns.strategy

trait Transportation {

  val name: String

  def transport() {
    println(name)
  }

}

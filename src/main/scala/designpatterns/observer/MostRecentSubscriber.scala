package designpatterns.observer

class MostRecentSubscriber extends Subscriber {

  val name = "MostRecentSubscriber"
  var data: Double = 0.0

  override def update(data: Double) {
    this.data = data
    println(name + ": " + data)
  }

}

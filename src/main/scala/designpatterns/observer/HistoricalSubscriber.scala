package designpatterns.observer

class HistoricalSubscriber extends Subscriber {

  val name = "HistoricalSubscriber"
  var count: Double = 0.0
  var avg: Double = 0.0

  override def update(data: Double) {
    val current = (count*avg) + data
    count += 1
    avg = current/count

    println(name + ": " + avg)
  }

}

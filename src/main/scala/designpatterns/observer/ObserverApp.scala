package designpatterns.observer

object ObserverApp {

  def main(args: Array[String]): Unit = {
    val pub = new Publisher
    val sub1 = new HistoricalSubscriber
    val sub2 = new MostRecentSubscriber

    pub.addFollower(sub1)
    pub.addFollower(sub2)

    pub.publish(12)
    pub.publish(1)
    pub.publish(23)
    pub.publish(49)
  }

}

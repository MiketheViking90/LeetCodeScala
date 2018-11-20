package designpatterns.observer

import scala.collection.mutable

class Publisher {

  var subscribers = new mutable.ArrayBuffer[Subscriber]

  def addFollower(sub: Subscriber) {
    subscribers += sub
  }

  def publish(data: Double) {
    for (sub <- subscribers) {
      sub.update(data)
    }
    println()
  }

}

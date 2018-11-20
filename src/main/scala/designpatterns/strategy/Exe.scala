package designpatterns.strategy

object Exe {

  def main(args: Array[String]): Unit = {
    val user1 = new User("Jim")
    val taxi = new Taxi()
    val bus = new Bus()

    user1.setTransportation(taxi)
    user1.goToAirport()
    user1.setTransportation(bus)
    user1.goToAirport()
  }

}

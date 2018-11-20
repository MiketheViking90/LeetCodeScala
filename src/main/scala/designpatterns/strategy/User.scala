package designpatterns.strategy

class User(val name: String) {

  var transportation: Transportation = _

  def setTransportation(auto: Transportation): Unit = {
    this.transportation = auto
  }

  def goToAirport():Unit = {
    println(name + " transporting ")
    transportation.transport()
  }

}

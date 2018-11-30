package decorator

class Shotgun extends Gun {

  val name = "shotgun"
  val price = 1000

  def getName() = {
    name;
  }

  def getPrice() = {
    price
  }

}

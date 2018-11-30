package decorator

abstract class GunAccessory(gun: Gun) extends Gun {

  val price: Double
  val name: String

  def getPrice() = {
    gun.getPrice() + price
  }

  def getName() = {
    gun.getName() + " with " + name
  }

}

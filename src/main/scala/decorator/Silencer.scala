package decorator

class Silencer(gun: Gun) extends GunAccessory(gun) {

  override val price: Double = 200
  override val name: String = "silencer"

}

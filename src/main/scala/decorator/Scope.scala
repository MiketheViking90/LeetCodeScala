package decorator

class Scope(gun: Gun) extends GunAccessory(gun) {

  override val price = 100
  override val name = "scope"

}

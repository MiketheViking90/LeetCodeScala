package decorator

object GunApp {

  def main(args: Array[String]): Unit = {
    var gun:Gun = new Shotgun()
    println(gun.getName() + ", " + gun.getPrice())

    gun = new Scope(gun)
    println(gun.getName() + ", " + gun.getPrice())

    gun = new Silencer(gun)
    println(gun.getName() + ", " + gun.getPrice())
  }

}

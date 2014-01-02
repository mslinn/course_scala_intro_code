package solutions

abstract class Animal2(numLegs: Int, breathesAir: Boolean) {
  private val breatheMsg = if (breathesAir) "" else " do not"
  val msg = s"I have $numLegs legs and I $breatheMsg breathe air"
}

class Bird(val canFly: Boolean, val topSpeed: Double) extends Animal2(2, true) {
  override def toString = s"canFly=$canFly; topSpeed=$topSpeed"
}

object Birds1 extends App {
  val falcon = new Bird(canFly=true, topSpeed=200)
  val emu = new Bird(canFly=false, topSpeed=25)
  println(s"Falcon $falcon")
  println(s"Emu $emu")
}

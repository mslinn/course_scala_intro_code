package solutions

import _root_.PatMatch6.Animal

class Bird(val canFly: Boolean, val topSpeed: Double) extends Animal(2, true) {
  override def toString = s"canFly=$canFly; topSpeed=$topSpeed"
}

object Birds1 extends App {
  val crane = new Bird(canFly=true, topSpeed=55)
  val emu   = new Bird(canFly=false, topSpeed=25)
  println(s"Crane $crane")
  println(s"Emu $emu")
}

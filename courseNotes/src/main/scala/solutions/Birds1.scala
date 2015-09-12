package solutions

import animals.Animal

class Bird(val canFly: Boolean, val topSpeed: Double) extends Animal(2, true) {
  override def toString = s"canFly=$canFly; topSpeed=$topSpeed"
}

object Birds1 extends App {
  val crane = new Bird(true, 55)
  val emu   = new Bird(false, 25)
  println(s"Crane $crane")
  println(s"Emu $emu")
}

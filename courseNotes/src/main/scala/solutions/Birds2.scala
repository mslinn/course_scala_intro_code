package solutions

import animals.Animal

class Bird2(val canFly: Boolean, val topSpeed: Double) extends Animal(2, true) {

  def this(topSpeed: Double) = {
    this(true, Bird2.newTopSpeed(topSpeed))
  }

  override def toString = s"canFly=$canFly; topSpeed=$topSpeed"
}

object Bird2 {
  def newTopSpeed(topSpeed: Double): Double = {
    val minutesOfHour: String = new java.text.SimpleDateFormat("mm").format(new java.util.Date)
    val evenMinute: Boolean = minutesOfHour.toInt%2 == 0
    if (evenMinute) topSpeed*1.1 else topSpeed
  }
}

object Birds2 extends App {
  val falcon = new Bird2(topSpeed=200)
  val emu = new Bird2(topSpeed=25)
  println(s"Falcon $falcon")
  println(s"Emu $emu")
}

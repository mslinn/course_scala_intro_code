abstract class BadAnimal(numLegs: Int, breathesAir: Boolean) {
  val x = 3 // part of primary constructor
  println(breathesAir) // part of primary constructor

  def whatAmI = s"$breathesAir;$numLegs legs"

  def anAbstractMethod(param: Int): String

  val y = 3 // part of primary constructor
}

abstract class Animal(numLegs: Int, breathesAir: Boolean) {
  private val breatheMsg = if (breathesAir) "" else " do not"
  val msg = s"I have $numLegs legs and I$breatheMsg breathe air"
}

class Frog1(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir)

object Animals1 extends App {
  val frog = new Animal(4, true) { val canSwim: Boolean = true }
  println(s"frog.msg=${frog.msg}")

  val frog1 = new Frog1(true, 4, true)
  println(s"frog1.canSwim=${frog.canSwim}")
}



class Frog2(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean) extends Animal(numLegs, breathesAir)

object Animals2 extends App {
  val tadpole = new Frog2(true, 0, false)
  println(s"tadpole.numLegs=${tadpole.numLegs}")
  println(s"tadpole.breathesAir=${tadpole.breathesAir}")
}


object Animals3 extends App {
  val frog2b = new Frog2(breathesAir=true, numLegs=4, canSwim=true)
  //val frog2c = new Frog2(breathesAir=true, numLegs=4)
  println(s"frog2b.canSwim=${frog2b.canSwim}")
}


class Frog3(val canSwim: Boolean, var numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir)

object Animals4 extends App {
  val frog3 = new Frog3(canSwim=true, 4, breathesAir=true)
  println(s"frog3.numLegs=${frog3.numLegs}")

  frog3.numLegs=5
  println(s"After assignment, frog3.numLegs=${frog3.numLegs}")

  // frog3.canSwim=false
}

println("Hello, world!")
abstract class Animal(numLegs: Int, breathesAir: Boolean)
abstract class Animal(numLegs: Int, breathesAir: Boolean) {
  private val breatheMsg = if (breathesAir) "" else "do not"
  val msg = s"I have $numLegs legs and I $breatheMsg breathe air" 
}
val frog = new Animal(4, true) { val canSwim: Boolean = true }
frog.msg
class Frog1(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir)
val frog1 = new Frog1(true, 4, true)
frog1.canSwim
class Frog2(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean) extends Animal(numLegs, breathesAir)
val tadpole = new Frog2(true, 0, false)
tadpole.numLegs
tadpole.breathesAir
val frog2b = new Frog2(breathesAir=true, numLegs=4, canSwim=true)
val frog2c = new Frog2(breathesAir=true, numLegs=4)
tadpole.canSwim
class Frog3(val canSwim: Boolean, var numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir)
val frog3 = new Frog3(canSwim=true, 4, breathesAir=true)
frog3.numLegs=4
frog3.canSwim=false
val frog3b = new Frog3(canSwim=true, 4, breathesAir=true) { override def toString() = s"$canSwim; $numLegs legs; $breathesAir" }
val frog3c = new Frog3(canSwim=true, 4, breathesAir=true) { override def toString() = s"$canSwim; $numLegs legs" }
frog3c
class Frog4(val canSwim: Boolean, var numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir) { override def toString() = s"$canSwim; $numLegs legs" }
val frog4 = new Frog4(canSwim=true, 4, breathesAir=true)
class Frog5(val canSwim: Boolean=true, var numLegs: Int=4, breathesAir: Boolean=true) extends Animal(numLegs, breathesAir) { override def toString() = s"$canSwim; $numLegs legs" }
val frog5 = new Frog5


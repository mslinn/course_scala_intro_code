abstract class Animal(numLegs: Int, breathesAir: Boolean) {
  private val breatheMsg = if (breathesAir) "" else "do not"
  val msg = s"I have $numLegs legs and I $breatheMsg breathe air"

  def this() = this(2, breathesAir=true)
}
val animal = new Animal(){}
animal.msg
object Animal2 {
  def shazam(numLegs: Int, breathesAir: Boolean) = {
    val breatheMsg = if (breathesAir) "" else "do not"
    s"I have $numLegs legs and I $breatheMsg breathe air"
  }
}
abstract class Animal2(val msg: String) {
  def this(numLegs: Int, breathesAir: Boolean) = this(Animal2.shazam(numLegs, breathesAir))
}
object Animal2 {
  def shazam(numLegs: Int, breathesAir: Boolean) = {
    val breatheMsg = if (breathesAir) "" else "do not"
    s"I have $numLegs legs and I $breatheMsg breathe air"
  }
}
abstract class Animal2(val msg: String) {
  def this(numLegs: Int, breathesAir: Boolean) = this(Animal2.shazam(numLegs, breathesAir))
}
val animal2 = new Animal2("asdf"){}
animal2.msg


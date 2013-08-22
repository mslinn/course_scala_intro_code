abstract class Animal(numLegs: Int, breathesAir: Boolean) {
  private val breatheMsg = if (breathesAir) "" else "do not"
  val msg = s"I have $numLegs legs and I $breatheMsg breathe air"

  def this() = this(2, true)
}


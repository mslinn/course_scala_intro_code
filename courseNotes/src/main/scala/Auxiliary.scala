object Auxiliary extends App {
  class Animal3(numLegs: Int, breathesAir: Boolean) {
    private val breatheMsg = if (breathesAir) "" else " do not"
    val msg = s"I have $numLegs legs and I$breatheMsg breathe air"

    def this() = this(numLegs=2, breathesAir=true) // specifying return type is not allowed

    override def toString = s"numLegs: $numLegs, breathesAir: $breathesAir, msg: $msg"
  }

  object Animal3 {
    def apply(numLegs: Int, breathesAir: Boolean): Animal3 = new Animal3(numLegs, breathesAir)

    def apply(): Animal3 = new Animal3 // method definition must have parentheses!
  }

  val animal3a = new Animal3(4, true)
  val animal3b = Animal3(4, true)
  val animal3c = new Animal3
  val animal3d = Animal3() // without parentheses you get a reference to Animal3.apply, instead of invoking it
  println(s"animal3a=$animal3a")
  println(s"animal3b=$animal3b")
  println(s"animal3c=$animal3c")
  println(s"animal3d=$animal3d")
}

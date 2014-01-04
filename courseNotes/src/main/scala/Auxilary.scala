object Auxilary1 extends App {
  class Animal3(numLegs: Int, breathesAir: Boolean) {
    private val breatheMsg = if (breathesAir) "" else "do not"
    val msg = s"I have $numLegs legs and I $breatheMsg breathe air"

    def this() = this(2, breathesAir=true)

    override def toString() = s"Animal3:msg=$msg"
  }

  val animal3 = new Animal3()
  println(s"animal3.msg=${animal3.msg}")
}


object Auxilary2 extends App {
  object Animal4 {
    def apply(numLegs: Int, breathesAir: Boolean): Animal4 = new Animal4(numLegs, breathesAir)

    def apply(): Animal4 = new Animal4 // method definition must have parentheses!
  }

  class Animal4(numLegs: Int, breathesAir: Boolean) {
    private val breatheMsg = if (breathesAir) "" else "do not"
    val msg = s"I have $numLegs legs and I $breatheMsg breathe air"

    def this(): Animal4 = this(numLegs=2, breathesAir=true)

    override def toString() = s"Animal4: numLegs$numLegs, breathesAir=$breathesAir, msg=$msg"
  }

  val animal4a = new Animal4(4, true)
  val animal4b = Animal4(4, true)
  val animal4c = new Animal4
  val animal4d = Animal4() // without parentheses you get a reference to Animal4.apply, instead of invoking it
  println(s"animal4a=$animal4a")
  println(s"animal4b=$animal4b")
  println(s"animal4c=$animal4c")
  println(s"animal4d=$animal4d")
}
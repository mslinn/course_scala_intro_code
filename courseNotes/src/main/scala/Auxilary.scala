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
    def shazam(numLegs: Int, breathesAir: Boolean) = {
      val breatheMsg = if (breathesAir) "" else "do not"
      s"I have $numLegs legs and I $breatheMsg breathe air"
    }
  }

  class Animal4(val msg: String) {
    def this(numLegs: Int, breathesAir: Boolean) = this(Animal4.shazam(numLegs, breathesAir))

    override def toString() = s"Animal4:msg=$msg"
  }

  val animal4 = new Animal4("asdf")
  println(s"animal4.msg=${animal4.msg}")
}

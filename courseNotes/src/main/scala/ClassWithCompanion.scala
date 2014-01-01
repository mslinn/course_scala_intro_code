class ClassWithCompanion(val x: Int)

object ClassWithCompanion {
  def apply(x: Int) = new ClassWithCompanion(x)
}


object Animals7 extends App {
  class Frog6(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean) {
    override def toString() = s"canSwim: $canSwim; $numLegs legs; breathesAir: $breathesAir"
  }

  object Frog6 {
    def apply(canSwim: Boolean=true, numLegs: Int=4, breathesAir: Boolean=true) = new Frog6(canSwim, numLegs, breathesAir)
  }

  val frog6a = Frog6(canSwim=true)
  val frog6b = Frog6.apply(canSwim=true)
  println(s"frog6a=$frog6a")
  println(s"frog6b=$frog6b")
}


object Animals8 extends App {
  class Frog8(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean) {
    override def toString() = s"canSwim: $canSwim; $numLegs legs; breathesAir: $breathesAir"
  }

  object Frog8 {
    def apply(canSwim: Boolean=true, numLegs: Int=4, breathesAir: Boolean=true) = new Frog8(canSwim, numLegs, breathesAir)

    def unapply(frog: Frog8):Option[(Boolean, Int, Boolean)] = Some((frog.canSwim, frog.numLegs, frog.breathesAir))
  }

  val Frog8(a, b, c) = Frog8(true, 4, false)
  println(s"a=$a, b=$b, c=$c")
}

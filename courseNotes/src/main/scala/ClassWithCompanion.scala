class ClassWithCompanion(val x: Int)

object ClassWithCompanion {
  def apply(x: Int) = new ClassWithCompanion(x)
}


object Animals7 extends App {
  class Frog6(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean) {
    override def toString = s"canSwim: $canSwim; $numLegs legs; breathesAir: $breathesAir"
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
  class Frog7(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean) {
    import Frog7.croak

    def makeNoise = croak(3)

    override def toString = s"canSwim: $canSwim; $numLegs legs; breathesAir: $breathesAir"
  }

  object Frog7 {
    def apply(canSwim: Boolean=true, numLegs: Int=4, breathesAir: Boolean=true) = new Frog7(canSwim, numLegs, breathesAir)

    def croak(times: Int): String = ("Croak " * times).trim
  }

  println(Frog7(canSwim=true, 4, breathesAir=true).makeNoise)
}

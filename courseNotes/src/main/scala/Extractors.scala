object Fractions extends App {
  class Fraction(var numerator:Int, var denominator:Int) {
    def *(fraction: Fraction) = Fraction(numerator*fraction.numerator, denominator*fraction.denominator)

    override def toString = s"$numerator/$denominator"
  }

  object Fraction {
    def apply(numerator: Int, denominator: Int) = new Fraction(numerator, denominator)

    def unapply(fraction: Fraction) = if (fraction==null) None else Some(fraction.numerator, fraction.denominator)
  }

  val fraction = Fraction(3,4) * Fraction(2,4)
  println(s"fraction=$fraction")
  val Fraction(numer, denom) = Fraction(1, 4) * Fraction(4, 5)
  println(s"numer=$numer, denom=$denom")
}


object Animals9 extends App {
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

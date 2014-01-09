object CaseClasses1 extends App {
  case class Frog9a(canSwim: Boolean, numLegs: Int, breathesAir: Boolean)

  case class Frog9b(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean)

  case class Frog9c(canSwim: Boolean, var numLegs: Int, breathesAir: Boolean)

  val frog9a = Frog9a(canSwim=true, 4, breathesAir=true)
  val frog9b = Frog9b(canSwim=true, 4, breathesAir=true)
  val frog9c = Frog9c(canSwim=true, 4, breathesAir=true)
  println(s"frog9a=$frog9a")
  println(s"frog9b=$frog9b")
  println(s"frog9c=$frog9c")
  frog9c.numLegs = 2
  println(s"frog9c=$frog9c")
}


object CaseClasses2 extends App {
  case class Dog(name: String)

  case class Hog(name: String)

  val dog1 = Dog("Fido")
  val dog2 = Dog("Fifi")
  val hog = Hog("Porky")

  println(s"Should two dogs be compared? ${dog1.canEqual(dog2)}")
  println(s"Comparing ${dog1.name} with ${dog2.name} gives: ${dog1==dog2}")

  println(s"Should a dog be compared to a hog? ${dog1.canEqual(hog)}")
  println(s"Comparing ${dog1.name} with ${hog.name} even though we should not do so gives: ${dog1==hog}")
}


object CaseClasses3 extends App {
  abstract class AbstractFrog(canSwim: Boolean, numLegs: Int, breathesAir: Boolean) {
    override def toString: String = s"canSwim: $canSwim, numLegs=$numLegs, breathesAir=$breathesAir"
  }

  case class Frog10(canSwim: Boolean, numLegs: Int, breathesAir: Boolean)
    extends AbstractFrog(canSwim, numLegs, breathesAir)

  val frog10 = Frog10(canSwim=true, 4, breathesAir=true)
  println(s"frog10=$frog10")
}


object ComplexCase extends App {
  case class Complex(re : Double, im : Double) {
    def + (another : Complex) = Complex(re + another.re, im + another.im)

    def unary_- = Complex(-re, -im)

    override def toString = s"${re}+${im}i"
  }

  println(s"Complex(2, 5) + Complex(1, -2) = ${Complex(2, 5) + Complex(1, -2)}")
  println(s"-Complex(1, -2) = ${-Complex(1, -2)}")
}

object StdMethods extends App {
  case class Frog9a(canSwim: Boolean, numLegs: Int, breathesAir: Boolean)
  case class Frog9c(canSwim: Boolean, var numLegs: Int, breathesAir: Boolean)

  val frog9a = Frog9a(canSwim=false, numLegs=4, breathesAir=true)
  val frog9c = Frog9c(canSwim=true, numLegs=4, breathesAir=true)

  println(s"frog9a=$frog9a")
  println(s"frog9c=$frog9c")

  val frog9a2 = frog9a.copy(canSwim=false)
  val frog9a3 = frog9a.copy(canSwim=false, numLegs=15)
  println(s"frog9a.copy(canSwim=false)=$frog9a2")
  println(s"frog9a.copy(canSwim=false, numLegs=15)=$frog9a3")

  println(s"Frog9a(true, 4, true).canEqual(Frog9c(true,4,true))=${Frog9a(true, 4, true).canEqual(Frog9c(true, 4, true))}")
  println(s"frog9a2 canEqual frog9a3=${frog9a2 canEqual frog9a3}")

  println(s"frog9a.equals(frog9c)=${frog9a.equals(frog9c)}")
  println(s"frog9a equals frog9c=${frog9a equals frog9c}")
  println(s"frog9a == frog9c=${frog9a == frog9c}")

  println(s"frog9a.hashCode=${frog9a.hashCode}")

  println(s"frog9a.productArity=${frog9a.productArity}")

  println(s"frog9a.productElement(0)=${frog9a.productElement(0)}")
  println(s"frog9a.productElement(1)=${frog9a.productElement(1)}")
  println(s"frog9.productElement(2)=${frog9a.productElement(2)}")

  frog9a.productIterator.foreach(println)

  println(s"frog9a.productPrefix=${frog9a.productPrefix}")

  println(s"frog9a.toString=${frog9a.toString}")
}

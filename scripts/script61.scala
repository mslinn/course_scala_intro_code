case class Frog9(canSwim: Boolean, numLegs: Int, breathesAir: Boolean)
case class Frog9b(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean)
case class Frog10(canSwim: Boolean, var numLegs: Int, breathesAir: Boolean)
val frog9 = Frog9(canSwim=true, 4, breathesAir=true)
val frog9b = frog9.copy(canSwim=false)
frog9 canEqual frog9b
Frog9(true, 4, true).canEqual(Frog10(true,4,true))
frog9.productArity
frog9.productElement(0)
frog9.productElement(1)
frog9.productElement(2)
frog9.productIterator.foreach(println)
frog9.productPrefix
frog9.toString
frog9
val Frog9(x, y, z) = frog9
val Frog9(a, _, b) = frog9


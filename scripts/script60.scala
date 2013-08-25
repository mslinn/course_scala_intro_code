:paste
class Frog1(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean)
object Frog1 {
  def apply(canSwim: Boolean=true, numLegs: Int=4, breathesAir: Boolean=true) = new Frog1(canSwim, numLegs, breathesAir)
}
^D
val frog1a = Frog1(canSwim=true)
val frog1b = Frog1.apply(canSwim=true)
:paste
class Frog4(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean) {
  import Frog4.croak

  def makeNoise = croak(3)
}
object Frog4 {
  def apply(canSwim: Boolean=true, numLegs: Int=4, breathesAir: Boolean=true) = new Frog4(canSwim, numLegs, breathesAir)

  def croak(times: Int): String = "Croak " * times
}
^D
Frog4(canSwim=true, 4, breathesAir=true).makeNoise


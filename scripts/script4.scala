class Frog1(val canSwim: Boolean, numLegs: Int, breathesAir: Boolean)
object Frog1 {
  def apply(canSwim: Boolean=true, numLegs: Int=4, breathesAir: Boolean=true) = new Frog1(canSwim, numLegs, breathesAir)
}
val frog1a = Frog1(canSwim=true)
val frog1b = Frog1.apply(canSwim=true)


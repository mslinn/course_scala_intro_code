package solutions

object Extractor extends App {
  type FrogTuple = (Boolean, Int, Boolean) // same as Tuple3[Boolean, Int, Boolean]
  type MaybeFrogTuple = Option[FrogTuple]  // same as Option[Tuple3[Boolean, Int, Boolean]]

  case class Frog9(canSwim: Boolean, numLegs: Int, breathesAir: Boolean) {
    override def toString() = s"canSwim=$canSwim, numLegs=$numLegs, breathesAir=$breathesAir"
  }

  object Frog9 {
    private def parse(input: Array[String]): MaybeFrogTuple =
      if (input.size!=3)
         None
      else
        try {
          Some((args(0).toBoolean, args(1).toInt, args(2).toBoolean))
        } catch {
          case e: Exception => None
        }

    def unapply(input: String): MaybeFrogTuple = parse(input.split(" "))

    def unapply(input: Array[String]): MaybeFrogTuple = parse(input)
  }

  def test {
    val Frog9(swimmer1, legCount1, airBreather1) = "true 4 true"
    val Frog9(swimmer2, legCount2, airBreather2) = "true 0 false"

    val Frog9(swimmer3, legCount3, airBreather3) = Array("true", "4", "true")
    val Frog9(swimmer4, legCount4, airBreather4) = Array("true", "0", "false")
  }

  // test

  val Frog9(swimmer, legCount, airBreather) = args
  println(s"swimmer = $swimmer")
  println(s"legCount = $legCount")
  println(s"airBreather = $airBreather")
}
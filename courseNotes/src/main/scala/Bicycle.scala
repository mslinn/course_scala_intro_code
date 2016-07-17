object Bicycle extends App {

  trait Cassette {
    /** The number of cogs on each gear in the cassette */
    protected def rearTeeth: Vector[Int]
  }

  trait TouringCassette extends Cassette {
    protected val rearTeeth = Vector(14, 16, 18, 20, 22, 24, 26)
  }

  trait RacingCassette extends Cassette {
    protected val rearTeeth = Vector(11, 12, 13, 14, 15, 17, 19, 21, 23, 25)
  }

  trait Tire {
    /** Circumference is measured in meters */
    def tireSize: Double
  }

  trait RacingTire extends Tire {
    val tireSize = 2.096
  }

  trait TrainingTire extends Tire {
    val tireSize = 2.196
  }

  /** A wheel requires a tire and a cassette */
  trait Wheel { self: Tire with Cassette =>
    /** @param numTurns a number of turns of the bicycle wheel as a real number
      * @return the total distance travelled for the given number of turns, in meters  */
    def turn(numTurns: Double): Double = self.tireSize * numTurns

    /** @param gear is the gear number, with the lowest number being the outside gear
      * @return the number of teeth of the given gear */
    def gearTeeth(gear: Int): Int =
      if (gear > rearTeeth.size) rearTeeth.last
      else if (gear < 1) rearTeeth.head
      else rearTeeth(gear - 1)

    def numGears = self.rearTeeth.size
  }

  class TrainingWheel extends Wheel with TrainingTire with TouringCassette

  class RacingWheel extends Wheel with RacingTire with RacingCassette

  /** Assume a single front chainring for simplicity */
  trait ChainRing {
    def frontTeeth: Int
  }

  class ChainRing50 extends ChainRing {
    val frontTeeth = 50
  }

  class ChainRing48 extends ChainRing {
    val frontTeeth = 48
  }

  /** A bike has a chainring and rear wheel components */
  case class Bike(chainRing: ChainRing, wheel: Wheel) {
    def gearRatio(gear: Int): Double = chainRing.frontTeeth.toDouble / wheel.gearTeeth(gear).toDouble

    def distancePerRevolution(gear: Int): Double = gearRatio(gear) * wheel.turn(1)

    /** @param rpm  revolutions per minute that the cyclist pedals
      * @param gear gear number that is currently engaged */
    def rpmToKph(rpm: Int = 90, gear: Int = 1): Double = distancePerRevolution(gear) * rpm * 60.0 / 1000.0

    val numGears: Int = wheel.numGears
  }

  val racingBike = Bike(new ChainRing50, new RacingWheel)
  println(f"racingBike.distancePerRevolution(1) = ${racingBike.distancePerRevolution(1)}%2.1f meters")
  println(f"racingBike.rpmToKph(95, 1) = ${racingBike.rpmToKph(95, 1)}%2.1f KpH")

  val touringBike = Bike(new ChainRing48, new TrainingWheel)
  println(f"touringBike.distancePerRevolution(5) = ${touringBike.distancePerRevolution(5)}%2.1f meters")
  println(f"touringBike.rpmToKph(95, 5) = ${touringBike.rpmToKph(95, 5)}%2.1f KpH")

  // Calculate speeds for each gear on the touring bike
  println("When riding a Touring Bike at 95 RPM, the speeds for each gear are:")
  1 to touringBike.numGears foreach { gear =>
    println(f"Gear $gear: Speed is ${touringBike.rpmToKph(95, gear)}%2.1f KpH")
  }
}

object FormattedStringSamples extends App {
  val int = 123
  val double = 123.4567
  val string = "Hello"
  println(f"Signed Integer right-justified at least 6 wide                                                     |$int%6d|")
  println(f"Signed Integer left-justified at least 6 wide                                                      |$int%-6d|")
  println(f"Integer right-justified at least 6 wide, zero filled                                               |$int%06d|")
  println(f"Integer right-justified at least 6 wide, leading +                                                 |$int%+6d|")
  println(f"Floating point right-justified at least 9 wide, 2 positions after the decimal                      |$double%10.2f|")
  println(f"Floating point left-justified at least 9 wide, 2 positions after the decimal                       |$double%-10.2f|")
  println(f"Floating point scientific notation right-justified at least 10 wide, 2 positions after the decimal |$double%10.2E|")
  println(f"Floating point scientific notation left-justified at least 10 wide, 2 positions after the decimal  |$double%-10.2E|")
  println(f"String minimum length 10, right-justified                                                          |$string%10s|")
  println(f"String minimum length 10, left-justified                                                           |$string%-10s|")
  println(f"Computation minimum length 10, right-justified                                                     |${int * double}%-10.2f|")
  println(f"Computation minimum length 10, left-justified                                                      |${int * double}%10.2f|")
}

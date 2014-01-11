object SealedDemo extends App {
  sealed abstract class Color
  class White extends Color
  class Yellow extends Color
  class Blue extends Color
  class Green extends Color
  class Black extends Color

  def colorSwatch(color: Color): Unit = color match {
    case color: White => println("White")
    case color: Yellow => println("Yellow")
    case color: Blue => println("Blue")
    case color: Green => println("Green")
    case color: Black => println("Black")
  } // If one of the cases is commented out, the compiler will complain that the color was not tested for

  colorSwatch(new Blue)
}


object Extractor extends App {
  case class Frog11(canSwim: Boolean, numLegs: Int, breathesAir: Boolean)

  case class Dog3(name: String, barksTooMuch: Boolean)

  case class Horse(name: String)

  def extract(animal: Any): String = animal match {
    case Frog11(canSwim, numLegs, breathesAir) if numLegs>0 =>
      s"Got a Frog11 with $numLegs legs; canSwim=$canSwim and breathesAir=$breathesAir"


    case Frog11(canSwim, numLegs, breathesAir) =>
      s"Got a tadpole without legs; breathesAir=$breathesAir"

    case Dog3(name, barksTooMuch) =>
      s"Got a Dog3 called $name and barksTooMuch=$barksTooMuch"

    case x =>
      s"Got an unexpected animal: $x"
  }

  println(extract(new Dog3("Fido", barksTooMuch=false)))
  println(extract(new Dog3("Fifi", barksTooMuch = true)))
  println(extract(new Frog11(canSwim=true, 0, breathesAir=false)))
  println(extract(new Frog11(canSwim=true, 4, breathesAir=true)))
  println(extract(new Horse("Silver")))
}


object PMQuiz extends App {
  case class Frog12(canSwim: Boolean, numLegs: Int, breathesAir: Boolean)

  val frog12 = Frog12(canSwim=true, numLegs=4, breathesAir=true)

  frog12 match { // match by type only, unapply is not invoked
    case kermit: Frog12 => println(s"kermit=$kermit")

    case other => println(other)
  }

  frog12 match { // match by type and invoke unapply implicitly to extract properties as separate variables
    case Frog12(a, b, c) => println(s"Extracted properties are: canSwim=$a, numLegs=$b, breathesAir=$c")

    case other => println(other)
  }
}


object Aliases extends App {
  case class Address(street: String, street2: String, city: String, country: String)

  val addresses = List(
    Address("840 Main St", "Suite B2", "Half Moon Bay", "CA"),
    Address("234 Rue Blue", "Apt 5", "Fontaineblue", "France"),
    Address("543 Toulouse", "Apt 6", "Paris", "France")
  )

  addresses foreach { _ match {
      case address @ Address(_, _, "Paris", "France") => println(address.street)
      case _ =>
    }
  }
}

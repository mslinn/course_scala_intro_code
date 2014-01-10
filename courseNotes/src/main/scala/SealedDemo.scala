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

  println(colorSwatch(new Blue))
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
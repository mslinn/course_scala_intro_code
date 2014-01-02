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
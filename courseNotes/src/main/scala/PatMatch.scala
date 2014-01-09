object PatMatch1 extends App {
  def matchOnValue(x: String): Int =
    x match {
      case "a" => 1
      case "b" => 2
      case "c" => 3
      case _ => 0
    }

  println(s"""matchOnValue("a")=${matchOnValue("a")}""")
  println(s"""matchOnValue("b")=${matchOnValue("b")}""")
  println(s"""matchOnValue("q")=${matchOnValue("q")}""")


  def maybeSystemProperty(name: String): String =
    Option(System.getProperty(name)) match {
      case Some(value) => s"Property $name value=$value" // value is extracted from the Option
      case None    => "Property blah is not defined"
    }

  println(s"""maybeSystemProperty("os.name")=${maybeSystemProperty("os.name")}""")
  println(s"""maybeSystemProperty("a")=${maybeSystemProperty("a")}""")


  def whatever: Any = if (System.currentTimeMillis % 2 == 0) 1 else "blah"

  whatever match {
    case a: Int    => println("Whatever: no")
    case b: String => println(s"Whatever: $b")
  }

  whatever match {
    case x: Int if x<3 => println("X is an integer less than 3")
    case x: Int        => println("X is an integer greater or equal to 3")
    case _             => println("X is not an integer")
  }
}


object PatMatch2 extends App {

}

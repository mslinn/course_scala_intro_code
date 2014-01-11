object PatMatch1 extends App {
  def matchOnValue(x: String): Int =
    x match {
      case "a" => 1
      case _   => 0
    }

  println(s"""matchOnValue("a")=${matchOnValue("a")}""")
  println(s"""matchOnValue("q")=${matchOnValue("q")}""")

  def matchOnValue2(x: String): Int =
    x match {
      case "a" => 1
      case y   => if (y.isEmpty) 0 else y.charAt(0)
    }

  println(s"""matchOnValue2("a")=${matchOnValue2("a")}""")
  println(s"""matchOnValue2("q")=${matchOnValue2("q")}""")
}


object PatMatch2 extends App {
  def matchOnValue3(x: String): Int =
    x match {
      case "a" => 1
      case y if y.isEmpty => 0
      case y              => y.charAt(0).toInt // if the guard fails then this is the catch-all case
    }

  println(s"""matchOnValue3("a")=${matchOnValue3("a")}""")
  println(s"""matchOnValue3("q")=${matchOnValue3("q")}""")
}


object PatMatch3 extends App {
  def whatever: Any = if (System.currentTimeMillis % 2 == 0) 1 else "blah"

  whatever match {
    case a: Int    => println(s"Whatever: Int with value $a")
    case b: String => println(s"Whatever: String with value '$b'")
  }

  /* Compiler complains "scrutinee is incompatible with pattern type"
  false match {
    case a: Int    => println("Whatever: Int with value $a")
    case b: String => println(s"Whatever: String with value '$b'")
  } */

  /* Runtime error: "scala.MatchError: false (of class java.lang.Boolean)"
  (false: Any) match {
    case a: Int if x<3 => println(s"$a is an integer less than 3")
    case b: Int        => println(s"$b is an integer greater or equal to 3")
  } */

  (false: Any) match {
    case a: Int if a<3 => println(s"$a is an integer less than 3")
    case b: Int        => println(s"$b is an integer greater or equal to 3")
    case x             => println(s"$x is not an integer")
  }

  whatever match {
    case a: Int if a<3 => println(s"$a is an integer less than 3")
    case b: Int        => println(s"$b is an integer greater or equal to 3")
    case x             => println(s"$x is not an integer")
  }
}


object PatMatch4 extends App {
  def maybeSystemProperty(name: String): String =
    Option(System.getProperty(name)) match {
      case Some(value) => s"Property '$name' value='$value'" // value is extracted from the Option
      case None        => "Property '$name' is not defined"
    }

  println(s"""maybeSystemProperty("os.name")=${maybeSystemProperty("os.name")}""")
  println(s"""maybeSystemProperty("a")=${maybeSystemProperty("a")}""")
}


object PatMatch5 extends App {
  def guardedTypeMatch(value: Any): String = value match {
    case a: Int if a<3 => s"$a is an integer less than 3"
    case b: Int        => s"$b is an integer greater or equal to 3"
    case _             => "Did not get an integer" // catch-all case
  }

  println(s"""guardedTypeMatch(0)=${guardedTypeMatch(0)}""")
  println(s"""guardedTypeMatch(99)=${guardedTypeMatch(99)}""")
  println(s"""guardedTypeMatch("blah")=${guardedTypeMatch("blah")}""")
}


object PatMatch6 extends App {
  abstract class Animal(numLegs: Int, breathesAir: Boolean) {
    private val breatheMsg = if (breathesAir) "" else " do not"
    val msg = s"I have $numLegs legs and I $breatheMsg breathe air"
  }

  case class Frog(canSwim: Boolean, numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir)

  case class Dog(barksTooMuch: Boolean) extends Animal(4, true)

  def classify(animal: Animal): String = animal match {
    case frog: Frog if frog.numLegs>0 =>
      s"Got a Frog with ${frog.numLegs} legs; canSwim=${frog.canSwim} and breathesAir=${frog.breathesAir}"

    case tadpole: Frog =>
      s"Got a tadpole without legs; breathesAir=${tadpole.breathesAir}"

    case dog: Dog if dog.barksTooMuch =>
      s"Got a Dog that barks too much"

    case dog: Dog =>
      s"Got a quiet Dog"

    case x =>
      s"Got an unexpected animal $x"
  }

  val frog1 = Frog(canSwim=true, 4, breathesAir=true)
  println(s"""classify(frog1)=${classify(frog1)}""")

  val tadpole = Frog(canSwim=true, 0, breathesAir=false)
  println(s"""classify(tadpole)=${classify(tadpole)}""")

  val bigDog = Dog(barksTooMuch=false)
  println(s"""classify(bigDog)=${classify(bigDog)}""")

  val yapper = Dog(barksTooMuch=true)
  println(s"""classify(yapper)=${classify(yapper)}""")
}

package solutions

object Unapply extends App {
  class Name(val first: String, val last: String)

  object Name {
    def unapply(input:String): Option[(String, String)] = {
      val stringArray = input.split(" ")
      if (stringArray.length>=2)
        Some(stringArray(0), stringArray(1))
      else
        None
    }
  }

  val Name(firstName, lastName) = "Fred Flintstone"
  println(firstName  + " " + lastName)
}


object Unapply2 extends App {
  class Name(val first: String, val last: String)

  object Name {
    def apply(a: String, b: String): Name = new Name(a, b)

    def unapply(name: Name): Option[(String, String)] = Some((name.first, name.last))

    def unapply(input: String): Option[(String, String)] = {
      val stringArray = input.split(" ")
      if (stringArray.length>=2)
        Some(stringArray(0), stringArray(1))
      else
        None
    }
  }

  val name: Name = try {
    val Name(firstName, lastName) = "Fred Flintstone"
    println(s"$firstName $lastName")
    Name(firstName, lastName)
  } catch {
    case me: MatchError =>
      println(s"Failed parse: ${me.getMessage()}")
      Name("nobody", "atAll")

    case huh: Throwable =>
      println(huh.getMessage)
      Name("Uno", "Who")
  } finally {
    Name("Wilma", "Flintstone")
  }
  println(s"Matched type ${name.getClass.getName}")

  name match {
    case Name(fName, _) if fName != "Fred" => println(s"Got one: $fName")

    case Name(fName, "Flintstone") => println(fName)

    case name: Name => println(name.first)
  }
}


object Unapply3 {
  class Frog8(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean) {
    override def toString = s"canSwim: $canSwim; $numLegs legs; breathesAir: $breathesAir"
  }

  object Frog8 {
    def apply(canSwim: Boolean=true, numLegs: Int=4, breathesAir: Boolean=true) = new Frog8(canSwim, numLegs, breathesAir)

    def unapply(frog: Frog8):Option[(Boolean, Int, Boolean)] = Some((frog.canSwim, frog.numLegs, frog.breathesAir))

    def unapply(string: String): Option[(Boolean, Int, Boolean)] = {
      val tokens = string.split(" ")
      if (tokens.length>=3)
        Some((tokens(0).toBoolean, tokens(1).toInt, tokens(2).toBoolean))
      else
        None
    }
  }
}

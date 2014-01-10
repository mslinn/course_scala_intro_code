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

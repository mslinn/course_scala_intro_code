package solutions

object PatMatch101b extends App {
  class Name(val first:String, val last:String)

  object Name {
    def apply(a: String, b: String): Name = new Name(a, b)

    def unapply(input: String): Option[(String, String)] = {
      val stringArray = input.split(" ")
      if (stringArray.length>=2)
        Some(stringArray(0), stringArray(1))
      else
        None
    }
  }

  val x = try {
    val Name(firstName, lastName) = "Fred Flintstone"
    println(s"$firstName $lastName")
    Name(firstName, lastName)
  } catch {
    case me: MatchError =>
      println(s"Failed parse: ${me.getMessage}")
      Name("nobody", "atAll")

    case huh: Throwable =>
      println(huh.getMessage)
      Name("Uno", "Who")
  } finally {
    Name("Wilma", "Flintstone")
  }
  println(x.getClass.getName)

/*
  x match {
    case Name(a, _) if a != "Fred" =>
      println(s"Got one: $a")
      val z = "asdf"

    case Name(a, "Flintstone") =>
      println(a)

    case name: Name =>
      println(name.first)

    case _: Any => println("Nope")
  }*/
}

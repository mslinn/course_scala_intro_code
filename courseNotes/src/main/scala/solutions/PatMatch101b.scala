package solutions

class Name(val first:String, val last:String)

object Name {
  def apply(a: String, b: String): Name = new Name(a, b)

  def unapply(input: String): Option[Tuple2[String, String]] = {
    val stringArray = input.split(" ")
    if (stringArray.length>=2)
      Some(stringArray(0), stringArray(1))
    else
      None
  }
}

object Main extends App {
  val x = try {
    val Name(firstName, lastName) = "Fred Flintstone"
    println(s"$firstName $lastName")
    Name(firstName, lastName)
  } catch {
    case me: MatchError =>
      println(s"Failed parse: ${me.getMessage}")
      Name("nobody", "nowhere")

    case huh: Throwable =>
      println(huh.getMessage)
      Name("Uno", "Who")
  } finally {
    Name("Wilma", "Flintsone")
  }
  println(x)

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

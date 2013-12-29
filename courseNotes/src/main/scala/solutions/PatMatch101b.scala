package solutions

class Name2(val first:String, val last:String)

object Name2 {
  def apply(a: String, b: String): Name2 = new Name2(a, b)

  def unapply(input: String): Option[Tuple2[String, String]] = {
    val stringArray = input.split(" ")
    if (stringArray.length>=2)
      Some(stringArray(0), stringArray(1))
    else
      None
  }
}

object PatMatch101b extends App {
  val x = try {
    val Name(firstName, lastName) = "Fred Flintstone"
    println(s"$firstName $lastName")
    Name2(firstName, lastName)
  } catch {
    case me: MatchError =>
      println(s"Failed parse: ${me.getMessage}")
      Name2("nobody", "nowhere")

    case huh: Throwable =>
      println(huh.getMessage)
      Name2("Uno", "Who")
  } finally {
    Name2("Wilma", "Flintsone")
  }
  println(x.getClass.getName)

/*
  x match {
    case Name2(a, _) if a != "Fred" =>
      println(s"Got one: $a")
      val z = "asdf"

    case Name2a, "Flintstone") =>
      println(a)

    case name: Name2 =>
      println(name.first)

    case _: Any => println("Nope")
  }*/
}

package solutions

class Name(val first: String, val last: String)

object Name {
  def unapply(input:String): Option[Tuple2[String, String]] = {
    val stringArray = input.split(" ")
    if (stringArray.length>=2)
      Some(stringArray(0), stringArray(1))
    else
      None
  }
}

object Unapply extends App {
  val Name(firstName, lastName) = "Fred Flintstone"
  println(firstName  + " " + lastName)
}

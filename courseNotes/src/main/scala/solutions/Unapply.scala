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

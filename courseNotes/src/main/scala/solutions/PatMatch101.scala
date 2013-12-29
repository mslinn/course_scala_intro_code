package solutions

object PatMatch101 extends App {
  Array("blah", 1, 1.0) foreach { valueToMatch =>
    val matchResult = valueToMatch match {
      case string: String =>
        s"Got a String: $string"

      case int: Int =>
        s"Got an Int: $int"

      case double: Double =>
        s"Got a Double: $double"
    }
    println(s"matchResult=$matchResult and is of type ${matchResult.getClass.getName}")
  }
}
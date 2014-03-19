package solutions

object PatMatch101a extends App {
  Array("blah", 1, 1.0) foreach { valueToMatch =>
    val matchResult: (Any, String) = valueToMatch match {
      case string: String =>
        (string, s"Got a String: $string")

      case int: Int =>
        (int, s"Got an Int: $int")

      case double: Double =>
        (double, s"Got a Double: $double")
    }
    println(s"matchResult=${matchResult._2} and is of type ${matchResult._1.getClass.getName}")
  }
}

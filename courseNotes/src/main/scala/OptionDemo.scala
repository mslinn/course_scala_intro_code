object OptionDemo1 extends App {
  val maybeAnswer: Option[Int] = Some(42)
  println(maybeAnswer.get)

  val maybeFavorite: Option[String] = None
  println(maybeFavorite.getOrElse("Bleah!"))

  maybeAnswer.foreach { x => println(3 * x) }   // prints the value of 42 times 3
  maybeFavorite.foreach { println }             // does not print anything

  val object1 = Some("Hi there")
  println(s"object1.isDefined=${object1.isDefined}")
  println(s"object1.isEmpty=${object1.isEmpty}")

  val object2 = None
  println(s"object2.isDefined=${object2.isDefined}")
  println(s"object2.isEmpty=${object2.isEmpty}")

}

object OptionDemo2 extends App {
  println(s""" Value of os.name is ${Option(System.getProperty("os.name"))}""")
  println(s""" Value of os.name.get is ${Option(System.getProperty("os.name")).get}""")
  println(s""" Value of not.present is ${Option(System.getProperty("not.present"))}""")
  println(s""" Value of os.name with default is ${Option(System.getProperty("os.name")).orElse(Some("default"))}""")
  println(s""" Value of os.name with default.get is ${Option(System.getProperty("os.name")).orElse(Some("default")).get}""")
  println(s""" Value of not.present with default.getOrElse is ${Option(System.getProperty("not.present")).getOrElse("default")}""")
  println(s""" Value of os.name with default.getOrElse is ${Option(System.getProperty("os.name")).getOrElse("default")}""")
}
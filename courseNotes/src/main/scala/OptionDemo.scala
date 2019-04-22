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

/** Uncomment this for Scala 2.13 after this projects' dependencies are available for Scala 2.13 */
/*object OptionDemo_2_13 extends App {
  println(s""""123".toIntOption = ${ "123".toIntOption }""")
  println(s""""123".toIntOption.map(_+1000) = ${ "123".toIntOption.map(_+1000) }""")
  println(s""""asf".toIntOption.map(_+1000) = ${ "asf".toIntOption.map(_+1000) }""")
  println(s""""true".toBooleanOption = ${ "true".toBooleanOption }""")
  println(s""""false".toBooleanOption = ${ "false".toBooleanOption }""")
  println(s""""true".toBooleanOption.foreach( if (_) println("Yes"); else println("No") ) = ${ "true".toBooleanOption.foreach( if (_) println("Yes"); else println("No") ) }""")

  // note that there is no output because foreach does not return a value
  println(s""""asdf".toBooleanOption.foreach( if (_) println("Yes"); else println("No") ) = ${ "asdf".toBooleanOption.foreach( if (_) println("Yes"); else println("No") ) }""")
  println(s""""asdf".toBooleanOption.map( if (_) "Yes"; else "No" ) = ${ "asdf".toBooleanOption.map( if (_) "Yes"; else "No" ) }""")
  println(s""""123".toBooleanOption = ${ "123".toBooleanOption }""")
  println(s""""1".toDoubleOption = ${ "1".toDoubleOption }""")
  println(s""""asdf".toDoubleOption = ${ "asdf".toDoubleOption }""")
}*/

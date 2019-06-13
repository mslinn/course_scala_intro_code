object OptionDemo_2_13 extends App {
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
}

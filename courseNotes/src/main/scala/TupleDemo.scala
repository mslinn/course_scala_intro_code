object TupleDemo extends App {
  println(s"""(1, 2, 3)=${(1, 2, 3)}""")
  println(s"""Tuple3(1, 2, 3)=${Tuple3(1, 2, 3)}""")
  println(s"""(1, 2.0, "abc")=${(1, 2.0, "abc")}""")
  val t3 = Tuple3(1, 2.0, "abc")
  println(s"""t3=$t3""")
  println(s""""key1" -> "value1"=${"key1" -> "value1"}""")
  println(s"""("key2", "value2")=${("key2", "value2")}""")
  println(s"""t3._1=${t3._1}""")
  println(s"""t3._2=${t3._2}""")
  println(s"""t3._3=${t3._3}""")
  println(s"""t3.copy(_2=4.2)=${t3.copy(_2=4.2)}""")
  println(s"""t3.copy(_1=99, _3="aardvark")=${t3.copy(_1=99, _3="aardvark")}""")
}

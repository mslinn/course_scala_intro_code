
object Closures extends App {
  val msg = "Blah. "
  val repeat: Int => String = msg * (_: Int)
  println(repeat(3))

  object Outer {
    val msg2 = "One more time! "
    object Inner {
      val repeat2: Int => String = msg2 * (_: Int)
      println(repeat2(3))
    }
  }
  Outer.Inner
}

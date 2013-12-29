object TypeWidening1 extends App {
  val x: Any = System.currentTimeMillis match {
    case evenMillis if evenMillis % 2 == 0 => true
    case millis if new java.util.Date(millis).toString.contains("Tue ") => "Today is a Tuesday"
    case rightNow => rightNow
  }
  println(s"x has type ${x.getClass.getName} and value $x")
}

object TypeWidening2 extends App {
  val rightNow = System.currentTimeMillis
  val x: Any = if (rightNow % 2 == 0) true
  else if (new java.util.Date(rightNow).toString.contains("Tue ")) "Today is a Tuesday"
  else rightNow
  println(s"x has type ${x.getClass.getName} and value $x")
}

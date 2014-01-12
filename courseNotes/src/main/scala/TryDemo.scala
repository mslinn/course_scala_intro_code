object TryDemo extends App {
  import scala.util.{Try, Success, Failure}

  def divide(dividend: Int, divisor: Int): Try[Int] = {
    Try(dividend/divisor) match {
      case Success(v) =>
        println(s"Result of $dividend/$divisor is: $v")
        Success(v)
      case Failure(e) =>
        println("You must have divided by zero or entered something that's not an Int.")
        println(s"Error: ${e.getMessage}")
        Failure(e)
    }
  }

  println(s"divide(4, 2)=${divide(4, 2)}")
  println(s"divide(2, 0)=${divide(2, 0)}")
}

object YodaHeis extends App {
  import scala.util.{Try => _, Success => Do, Failure => DoNot}

  def divide(dividend: Int, divisor: Int): util.Try[Int] = {
    util.Try(dividend/divisor) match {
      case Do(v) =>
        println(s"Result of $dividend/$divisor is: $v")
        Do(v)
      case DoNot(e) =>
        println("You must have divided by zero or entered something that's not an Int.")
        println(s"Error: ${e.getMessage}")
        DoNot(e)
    }
  }

  println(s"divide(4, 2)=${divide(4, 2)}")
  println(s"divide(2, 0)=${divide(2, 0)}")
}

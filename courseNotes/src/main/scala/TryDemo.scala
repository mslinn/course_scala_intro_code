import scala.util.{Try, Success, Failure}

object TryDemo extends App {
  def divide(dividend: Int, divisor: Int): Try[Int] = {
    Try(dividend/divisor) match {
      case Success(v) =>
        println(s"Result of $dividend/$divisor is: $v")
        Success(v)
      case Failure(e) =>
        println("You must have divided by zero or entered something that's not an Int. Try again!")
        println(e.getMessage)
        Failure(e)
    }
  }

  println(s"divide(4, 2)=${divide(4, 2)}")
  println(s"divide(2, 0)=${divide(2, 0)}")
}

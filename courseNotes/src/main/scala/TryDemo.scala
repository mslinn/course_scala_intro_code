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


object YodaHeIs extends App {
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


object TryCatch extends App {
  def divide(dividend: Int, divisor: Int): Int = {
    try {
      dividend/divisor
    } catch {
      case e: ArithmeticException =>
        println(e.getMessage)
        0

      case e: Exception =>
        println(s"Did not see this one coming! $e")
        0
    }
  }

  println(s"divide(4, 2)=${divide(4, 2)}")
  println(s"divide(2, 0)=${divide(2, 0)}")
}


object TryCatch2 extends App {
  def divide(dividend: Int, divisor: Int): Int = {
    try {
      dividend/divisor
    } catch {
      case e: ArithmeticException =>
        println(e.getMessage)
        0

      case e: Exception =>
        println(s"Did not see this one coming! $e")
        0
    } finally {
        println("The end")
    }
  }

  println(s"divide(4, 2)=${divide(4, 2)}")
  println(s"divide(2, 0)=${divide(2, 0)}")
}


object TryCatch3 extends App {
  import scala.util.{Try, Success, Failure}

  def divide(dividend: Int, divisor: Int): Try[Int] = {
    try {
      Success(dividend/divisor)
    } catch {
      case e: Exception =>
        println(e.getMessage)
        Failure(e)
    }
  }

  println(s"divide(4, 2)=${divide(4, 2)}")
  println(s"divide(2, 0)=${divide(2, 0)}")
}


object TryCatch4 extends App {
  import scala.util.Try

  def divide(dividend: Int, divisor: Int): Try[Int] = Try(dividend/divisor)

  println(s"divide(4, 2)=${divide(4, 2)}")
  println(s"divide(2, 0)=${divide(2, 0)}")
}


object TryCatch5 extends App {
  import util.Try
  Try(4/0).map( x => x * 2 ).recover { case _ => 42 }
}

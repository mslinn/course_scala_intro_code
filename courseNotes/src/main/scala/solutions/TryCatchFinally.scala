package solutions

import util.{Try => _, Success => Do, Failure => DoNot}

object TryCatchFinally extends App {
  def divide(dividend: Int, divisor: Int): util.Try[Int] = {
    val result = util.Try(dividend/divisor)
    result match {
      case Do(v) =>
        println(s"Result of $dividend/$divisor is: $v")
        Do(v)
      case DoNot(e) =>
        println("You must have divided by zero or entered something that's not an Int. Try again!")
        println(e.getMessage)
        DoNot(e)
    }
    result
  }

  divide(4, 2)
  divide(2, 0)
}

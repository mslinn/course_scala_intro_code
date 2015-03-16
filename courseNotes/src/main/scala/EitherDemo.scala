object EitherDemo1 extends App {
  val result1: Either[String, String] = Right("yay!")
  println(s"result1.isRight=${result1.isRight}")
  println(s"result1.isLeft=${result1.isLeft}")
  println(s"result1.right.get=${result1.right.get}") // this is not the way to write production code!

  val result2: Either[String, String] = Left("Oops, I did it again!")
  println(s"result2.isRight=${result2.isRight}")
  println(s"result2.isLeft=${result2.isLeft}")
  println(s"result2.left.get=${result2.left.get}") // this is not the way to write production code!

  val folded: String = result2.fold(
    lhs => "Handled left side",
    rhs => "Handled right side"
  )
  println(s"folded=$folded")

  val folded2 = result2.fold[String](
    (lhs: String) => "Handled left side",
    (rhs: String) => "Handled right side"
  )
  println(s"folded2=$folded2")
}


object EitherDemo2 extends App {
  type IntString = Either[String, Int]

  def parse(in: String): IntString = try {
    Right(in.toInt)
  } catch {
    case e: Exception =>
      Left(in)
  }

  def show(either: IntString): Unit =
    println(either match {
      case Right(x) =>
        s"Parsed Int: $x"

      case Left(x) =>
        s"Unparseable String: $x"
    })

  show(parse("1234"))
  show(parse("12abc"))
  show(parse("abc1234"))
}

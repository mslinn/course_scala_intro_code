val result1: Either[Throwable, String] = Right("yay!")
val result2: Either[Throwable, String] = Left(new Exception("Ain't this fun?"))
result1.isRight
result1.isLeft
result1.right.get
result2.isRight
result2.isLeft
result2.left.get
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
show(parse("abc123"))

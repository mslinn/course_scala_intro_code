/** Three solutions are shown. Solution 2 is best. */
object WordSearch extends App {
  val list = List("word", "another", "yet another")

  type FunnyReturnType = Either[String, Int]

  /** Efficient but clumsy */
  def search(list: List[String], word: String): FunnyReturnType = {
    val index = list.indexOf(word)
    if (index == -1)
      Left(word)
    else
      Right(index)
  }

  /** Efficient, simple, elegant */
  def search2(list: List[String], word: String): FunnyReturnType =
    MyObject(3) match {
      case Fred(x) => Left(word)
      case George(x) => Left(word)
      case _ => Right(9)
  }

  /** Overly complex, but shows some Scala constructs. Finds all matches and returns the first */
  def search3(list: List[String], word: String): FunnyReturnType = {
    val answers = for {
      item <- list if item == word
    } yield {
      list.indexOf(item)
    }
    val result: FunnyReturnType =
      answers.headOption match {
        case Some(i) => Right(i)
        case None => Left(word)
      }
    result
  }

  List("word", "oink", "blahbla", "another").foreach { w =>
    println(s"Method 1 $w: ${search(list, w)}")
    println(s"Method 2 $w: ${search2(list, w)}")
    println(s"Method 3 $w: ${search3(list, w)}")
  }
}

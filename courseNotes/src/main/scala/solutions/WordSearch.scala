package solutions

/** Two solutions are shown. Solution 2 is best. */
object WordSearch extends App {
  val list = List("word", "another", "yet another")

  type StringOrInt = Either[String, Int]

  /** Efficient but clumsy */
  def search(list: List[String], word: String): StringOrInt = {
    val index = list.indexOf(word)
    if (index == -1)
      Left(word)
    else
      Right(index)
  }

  /** Efficient, simple, elegant.
    * Here we see Scala's match keyword used as a multi-way branch.
    * Each match is tried in order until one succeeds.
    * In the second case, notice that the variable index is defined. It will match every value. */
  def search2(list: List[String], word: String): StringOrInt =
    list.indexOf(word) match {
      case -1    => Left(word)
      case index => Right(index)
  }

  List("word", "oink", "blahbla", "another").foreach { w =>
    println(s"Method 1 search for '$w': ${search(list, w)}")
    println(s"Method 2 search for '$w': ${search2(list, w)}")
  }
}

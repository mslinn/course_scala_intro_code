package solutions

import org.specs2.mutable._

class Specs2Solution extends Specification {
  "ScalaCourses.com" should {
    "contain the word scala" in {
      val contents = io.Source.fromURL("http://scalacourses.com").getLines().mkString
      contents.toLowerCase must contain("scala")
    }
  }
}

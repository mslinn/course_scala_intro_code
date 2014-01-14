package solutions

import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Specs2Solution extends Specification {

  "ScalaCourses.com" should {
    "contain the word scala" in {
      val contents = io.Source.fromURL("http://scalacourses.com").getLines().mkString
      contents.toLowerCase must contain("scala")
    }
  }
}

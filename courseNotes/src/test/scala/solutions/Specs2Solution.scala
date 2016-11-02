package solutions

import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class TestSpecs2Solution extends Specification {
  "ScalaCourses.com" should {
    "contain the word scala" in {
      val contents = io.Source.fromURL("http://scalacourses.com").getLines.mkString
      contents.toLowerCase must contain("scala")
    }
  }
}

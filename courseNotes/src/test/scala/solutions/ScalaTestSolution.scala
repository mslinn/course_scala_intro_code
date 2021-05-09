package solutions

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec._
import scala.util.Using

class ScalaTestSolution extends AnyWordSpec {
  "ScalaCourses.com" should {
    "contain the word scala" in {
      Using(io.Source.fromURL("http://scalacourses.com")) { contents =>
        contents.getLines().mkString.toLowerCase should include("scala")
      }
    }
  }
}

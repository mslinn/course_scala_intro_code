package solutions

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec._
import scala.util.Using

class ScalaTestSolution extends AnyWordSpec {
  "ScalaCourses.com" should {
    "contain the word scala" in {
      val x = io.Source.fromURL("https://scalacourses.com")
      val contents = x.getLines.mkString
      x.close
      contents.toLowerCase should include("scala")

      //Using(io.Source.fromURL("https://scalacourses.com")) { contents =>
      //  contents.getLines().mkString.toLowerCase should include("scala")
      //}
    }
  }
}

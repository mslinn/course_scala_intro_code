package solutions

import org.scalatest._
import org.scalatest.Matchers._

class ScalaTestSolution extends WordSpec {
  "ScalaCourses.com" should {
    "contain the word scala" in {
      val x = io.Source.fromURL("https://scalacourses.com")
      val contents = x.getLines.mkString
      x.close
      contents.toLowerCase should include("scala")
    }
  }
}

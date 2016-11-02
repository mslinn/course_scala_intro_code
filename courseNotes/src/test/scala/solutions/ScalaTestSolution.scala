package solutions

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.Matchers._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ScalaTestSolution extends WordSpec {
  "ScalaCourses.com" should {
    "contain the word scala" in {
      val contents = io.Source.fromURL("http://scalacourses.com").getLines.mkString
      contents.toLowerCase should include("scala")
    }
  }
}

package solutions

import org.scalatest._

class ScalaTestSolution extends WordSpec {

  "ScalaCourses.com" should {
    "contain the word scala" in {
      val contents = io.Source.fromURL("http://scalacourses.com").getLines().mkString
      contents.toLowerCase.contains("scala")
    }
  }
}

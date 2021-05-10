package solutions

import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import scala.util.Using

@RunWith(classOf[JUnitRunner])
class Specs2Solution extends Specification {
  "ScalaCourses.com" should {
    "contain the word scala" in {
      Using(io.Source.fromURL("http://scalacourses.com")) { contents =>
        contents.getLines().mkString.toLowerCase should include("scala")
      }
    }
  }
}

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._
import org.scalatest.Matchers._

@RunWith(classOf[JUnitRunner])
class ScalaTestDemo extends WordSpec {
  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "Hello world".length === 11
    }

    "start with 'Hello'" in {
      "Hello world" should startWith("Hello")
    }

    "end with 'world'" in {
      "Hello world" should endWith("world")
    }
  }
}

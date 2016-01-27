import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class ScalaTestDemo extends WordSpec {

  """The "Hello world" string""" should {
    "contain 11 characters" in {
      assert("Hello world".length == 11)
    }

    """start with "Hello"""" in {
      assert("Hello world".startsWith("Hello"))
    }

    """end with "world"""" in {
      assert("Hello world".endsWith("world"))
    }
  }
}

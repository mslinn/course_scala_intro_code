import org.scalatest._

class ScalaTestDemo extends WordSpec {

  "The 'Hello world' string" should {
    "contain 11 characters" in {
      assert("Hello world".length == 11)
    }

    "start with 'Hello'" in {
      assert("Hello world".startsWith("Hello"))
    }

    "end with 'world'" in {
      assert("Hello world".endsWith("world"))
    }
  }
}

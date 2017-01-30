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

  "OptionValue" should {
    import org.scalatest.EitherValues._
    "work for Some values" in {
      val option = Some(3)
      option shouldBe defined
      option.value shouldBe 3
      option.value should be < 7
      option should contain oneOf (3, 5, 7, 9)
      List(3, 5, 7, 9) should contain (option.value)
      option should not contain oneOf (7, 8, 9)
      List(5, 7, 9) should not contain option.value
    }

    "work for None" in {
      val option: Option[Int] = None
      option shouldBe empty // the following are all equivalent:
      option shouldEqual None
      option shouldBe None
      option should === (None)
    }
  }

  "EitherValue" should {
    import org.scalatest.EitherValues._
    val either: Either[String, Int] = Right(3)
    "work for Right values" in {
      either.right.value shouldBe 3
      either shouldBe 'right
      either should not be 'left
    }
  }
}

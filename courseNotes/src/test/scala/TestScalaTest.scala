import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec._

class TestScalaTest extends AnyWordSpec {
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

  "Strings" should {
    val string = """Thank you for your order.
                   |You enrolled in the best course ever!
                   |Go study and become successful.
                   |""".stripMargin.replace("\r\n", "\n")
    "compare normally" in {
      string === string
      string.length shouldBe 96
      string should startWith("Thank you for your order")
      string should include("the best course ever!")
      string should endWith("successful.\n")
    }
    "compare with regexes" in {
      string should fullyMatch regex "(?s)Thank .* best .*"
      string should startWith regex "Thank .*"
      string should include regex "best course .*"
      string should endWith regex "successful.\n"
    }
  }

  "OptionValue" should {
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
      either.value shouldBe 3
      either shouldBe Symbol("right")
      either should not be Symbol("left")
    }
  }

  "Multiple predicates" should {
    "combine" in {
      val string = """Thank you for your order.
                     |You enrolled in the best course ever!
                     |Go study and become successful.
                     |""".stripMargin
      string should (
        include("Thank you for your order") and
        include("You enrolled in")
      )
      string should (
        include("Thank you for your order") or
        include("You enrolled in")
      )
    }
  }
}

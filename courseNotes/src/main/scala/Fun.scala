object LazyEval extends App {
  import java.util.Calendar

  /** The Leibniz series algorithm converges slowly to Pi. About 5 billion iterations are required to yield accuracy to 10 decimal places.
    * Pi is the limit of this series: 4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...
    * @see http://en.wikipedia.org/wiki/Leibniz_formula_for_%CF%80 */
  def leibnizPi(iterationCount: Long=5000000000L, digits: Int=10): BigDecimal = {
    val numerator: BigDecimal = 4.0
    var denominator: BigDecimal = 1
    var plus = true
    var result: BigDecimal = 0.0
    while (denominator < iterationCount) {
      if (plus) {
        result = result + numerator / denominator
        plus = false
      } else {
        result = result - numerator / denominator
        plus = true
      }
      denominator = denominator + 2
    }
    result.setScale(digits, BigDecimal.RoundingMode.HALF_UP)
  }

  val isWitchingHour: Boolean = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == 0
  val scaredMsg = "I am too scared to compute"

  def timidPi1(value: BigDecimal): String       = if (!isWitchingHour) s"Eager evaluation yields $value"        else scaredMsg
  def timidPi2(value: => BigDecimal): String    = if (!isWitchingHour) s"Lazy evaluation yields $value"         else scaredMsg
  def timidPi3(value: () => BigDecimal): String = if (!isWitchingHour) s"Evaluating function yields ${value()}" else scaredMsg

  println(timidPi1(leibnizPi()))        // eager evaluation
  println(timidPi2(leibnizPi()))        // lazy evaluation
  println(timidPi3(() => leibnizPi()))  // no-arg function
}

object Fun extends App {
  type IntDblToStr = (Int, Double) => String

  val mulStr = (a: Int, b: Double) => (a * b).toString
  println(s"mulStr(1, 2)=${mulStr(1, 2)}")

  val mulStr2: IntDblToStr = (a: Int, b: Double) => (a * b).toString
  println(s"mulStr2(1, 2)=${mulStr2(1, 2)}")

  val addFour = (_: Int) + 4
  println(s"addFour(10)=${addFour(10)}")

  val multiplyThree = (_: Int) * 3
  println(s"multiplyThree(20)=${multiplyThree(20)}")

  val mulStr3: IntDblToStr = new Function2[Int, Double, String] {
    def apply(a: Int, b: Double): String = (a * b).toString
  }
  println(s"mulStr3(1, 2)=${mulStr3(1, 2)}")
}


object Fun2 extends App {
  val ud = () => System.getProperty("user.dir")
  println(s"ud()=${ud()}")

  val ud2 = new Function0[String] { def apply(): String = System.getProperty("user.dir") }
  println(s"ud2()=${ud2()}")

  object R1 { def repeat(string: String, times: Int): String = string * times }
  println(s"""R1.repeat("a", 3)=${R1.repeat("a", 3)}""")

  val liftedFunction = R1.repeat _
  println(s"""liftedFunction("a", 3)=${liftedFunction("a", 3)}""")

  val f2: (String, Int) => String = (arg1, arg2) => arg1 * arg2
  println(s"""f2("a", 4)=${f2("a", 4)}""")

  val f3: Function2[String, Int, String] = (arg1, arg2) => arg1 * arg2
  println(s"""f3("a", 4)=${f3("a", 4)}""")
}


object Fun3 extends App {
  trait Fn extends (Int => Int) {
      def apply(x: Int): Int

      def ~(f: => Fn) = this andThen f
  }

  val addOne: Fn = new Fn { def apply(x: Int) = 1 + x }

  val multiplyTwo: Fn = new Fn { def apply(x: Int) = 2 * x }

  println(s"""addOne(2)=${addOne(2)}""")
  println(s"""multiplyTwo(4)=${multiplyTwo(4)}""")

  val compute = multiplyTwo andThen addOne
  println(s"compute(2)=${compute(2)}")

  println(s"(addOne ~ multiplyTwo)(6)=${(addOne ~ multiplyTwo)(6)}")
}

object WithFun extends App {
  case class Blarg(i: Int, s: String)

  def withBlarg(blarg: Blarg)(operation: Blarg => Unit): Unit = operation(blarg)

  withBlarg(Blarg(1, "asdf")) { blarg =>
    println(blarg)
  }

  withBlarg(Blarg(2, "qwerty")) { println(_) }

  withBlarg(Blarg(3, "zxcv")) { println }
}

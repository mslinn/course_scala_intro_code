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
}

package solutions

object FunSel extends App {
  type StringOp = (String, Int) => String

  def blackBox(f: StringOp, string: String, n: Int): String = f(string, n)

  val fn1: StringOp = _ substring _    // infix syntax
  //val fn1: StringOp = _.substring(_) // postfix syntax
  val fn2: StringOp = _ * _

  println(s"""fn1 supplied with "good/bad dog" and 5 gives: ${fn1("bad/good dog", 4)}""")
  println(s"""fn2 supplied with "arf " and 3 gives: ${fn2("arf ", 3)}""")
}

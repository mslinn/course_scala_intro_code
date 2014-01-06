object Anonymous1 extends App {
  val adhoc = new {
    def test(predicate: Boolean): String = if (predicate) "Yes" else "No"
  }

  println(s"adhoc.test(3>2)=${adhoc.test(3>2)}")
}


object Anonymous2 extends App {
  import java.util.Date

  val myDate = new Date { def dayAfter = new Date(getTime + 1000L*60L*60L*24L) }
  println(s"myDate.dayAfter=${myDate.dayAfter}")
}


object Anonymous3 extends App {
  abstract class A {
    val a: Int
    def doubleA: Int
  }

  val a = new A {
    val a = 3
    def doubleA = a * 2
  }

  println(s"a.doubleA=${a.doubleA}")
}
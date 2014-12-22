import scala.collection.mutable

object Fib1 extends App {
  def fib1(n: Int): Long = if (n<=1) n else fib1(n - 2) + fib1(n - 1)

  println(s"Fibonacci of 10   is: ${fib1(10)}")
 // println(s"Fibonacci of 50   is: ${fib1(100)}")   // Runs  for an hour or more
  //println(s"Fibonacci of 1000 is: ${fib1(1000)}")  // stack overflow
}

object Fib2 extends App {
  def fib2(n: Int): Long = {
    @annotation.tailrec
    def fibIter(fibNumM2: Long, fibNumM1: Long, count: Int): Long =
      if (count==0) fibNumM2
      else fibIter(fibNumM1, fibNumM2 + fibNumM1, count - 1)

    fibIter(0L, 1L, n)
  }

  println(s"Fibonacci of 10   is: ${fib2(10)}")
  println(s"Fibonacci of 50   is: ${fib2(50)}")
  println(s"Fibonacci of 100  is: ${fib2(100)}")  // arithmetic overflow! Gives wrong answer
  println(s"Fibonacci of 500  is: ${fib2(500)}")  // arithmetic overflow! Gives wrong answer
  println(s"Fibonacci of 1000 is: ${fib2(1000)}") // arithmetic overflow! Gives wrong answer
}

object Fib3 extends App {
  def fib3(n: Int): BigInt = {
    @annotation.tailrec
    def fibIter(fibNumM2: BigInt, fibNumM1: BigInt, count: Int): BigInt =
      if (count==0) fibNumM2
      else fibIter(fibNumM1, fibNumM2 + fibNumM1, count - 1)

    fibIter(BigInt(0), BigInt(1), n)
  }

  println(s"Fibonacci of 10   is: ${fib3(10)}")
  println(s"Fibonacci of 50   is: ${fib3(50)}")
  println(s"Fibonacci of 100  is: ${fib3(100)}")
  println(s"Fibonacci of 500  is: ${fib3(500)}")
  println(s"Fibonacci of 1000 is: ${fib3(1000)}")
  println(s"Fibonacci of 5000 is: ${fib3(5000)}")
}

object Fib4 extends App {
  val defaultMap = collection.immutable.HashMap(0 -> BigInt(0), 1 -> BigInt(1))
  val cache = collection.mutable.WeakHashMap[Int, BigInt]().withDefault(defaultMap)

  val fn: Int => BigInt = (n: Int) => {
    val result: BigInt = if (n<=1) n else fib4(n - 2) + fib4(n - 1)
    cache += (n -> result)
    result
  }

  def fib4(n: Int): BigInt = try {
    cache.getOrElse(n, fn(n))
  } catch {
    case soe: StackOverflowError =>
      println(s"StackOverflowError for n=$n")
      sys.exit(1)
  }

  println(s"Fibonacci of 10   is: ${fib4(10)}")
  println(s"Fibonacci of 50   is: ${fib4(50)}")
  println(s"Fibonacci of 100  is: ${fib4(100)}")
  println(s"Fibonacci of 500  is: ${fib4(500)}")
  println(s"Fibonacci of 1000 is: ${fib4(1000)}")
  println(s"Fibonacci of 5000 is: ${fib4(5000)}") // quickly overflows stack
}

// TODO move into Intermediate Scala
object Fib5 extends App {
  val memoizer = new Memoizer[Int, BigInt]()

  val fn: Int => BigInt = (n: Int) => if (n<=1) n else fib5(n - 2) + fib5(n - 1)

  val fib5: Int => BigInt  = (n: Int) => try {
    memoizer(n, fn)
  } catch {
      case soe: StackOverflowError =>
        println(s"StackOverflowError for n=$n")
        sys.exit(1)
    }

  /** A generic memoizer */
  class Memoizer[T, R](initialValues: (T, R)*) {
    val defaultMap = collection.immutable.HashMap(initialValues: _*)
    val cache = mutable.WeakHashMap[T, R]().withDefault(defaultMap)

    def apply(value: T, function: T => R): R =
      cache.getOrElseUpdate(value, function(value))
  }

  println(s"Fibonacci of 10   is: ${fib5(10)}")
  println(s"Fibonacci of 50   is: ${fib5(50)}")
  println(s"Fibonacci of 100  is: ${fib5(100)}")
  println(s"Fibonacci of 500  is: ${fib5(500)}")
  println(s"Fibonacci of 1000 is: ${fib5(1000)}")
  println(s"Fibonacci of 5000 is: ${fib5(5000)}") // quickly overflows stack
}

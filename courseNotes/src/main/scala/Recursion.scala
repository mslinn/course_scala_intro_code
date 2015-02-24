import scala.annotation.tailrec
import scala.collection.{immutable, mutable}
import scala.util.{Failure, Success}

object Time {
  def timeAndValue(n: Int, fn: Int => Any): (Long, Any) = {
    val s = System.currentTimeMillis
    val result = fn(n)
    (System.currentTimeMillis - s, result)
  }

  def printTiming(n: Int, fn: Int => Any, msg: String): Unit = {
    val result = timeAndValue(n, fn)
    println(f"[It took: ${result._1}%5d ms to run] " + f"$msg $n%6d is: ${result._2}")
  }

  def fibTest(fn: Int => Any, values: List[Int] = List(10, 42, 50, 100, 500, 1000, 1000, 5000, 5000)) =
    values.foreach(n => printTiming(n, fn, "Fibonacci of: "))

  def time(f: => Unit) = {
    val s = System.currentTimeMillis
    f
    System.currentTimeMillis - s
  }
}

object FibBad1 extends App {

  def fibBad1(n: Int): Long = n match {
    case 0L => 0L
    case 1L => 1L
    case _ => fibBad1(n - 2) + fibBad1(n - 1)
  }

  Time.fibTest(fibBad1, List(10, 42, 42))

  //println(s"Fibonacci of 50   is: ${fibBad1(100)}")   // Runs  for an hour or more
  //println(s"Fibonacci of 1000 is: ${fibBad1(1000)}")  // stack overflow
  //println(s"Fibonacci of -10 is: ${fibBad1(-10)}")    // stack overflow, because -ve numbers are not properly handled
}

object FibBad2 extends App {

  def fibBad2(n: Int): Long = if (n <= 1) n else fibBad2(n - 2) + fibBad2(n - 1)

  Time.fibTest(fibBad2, List(10, 42, 42))
  // println(s"Fibonacci of 50   is: ${fibBad2(100)}")  // Runs  for an hour or more
  //println(s"Fibonacci of 1000 is: ${fibBad2(1000)}")  // stack overflow
  //println(s"Fibonacci of -10 is: ${fibBad2(-10)}")    // gives an invalid result. -10, because -ve numbers are not properly handled
}

object Fib3 extends App {

  val defaultMap = immutable.HashMap(0 -> 0L, 1 -> 1L)
  val cache = mutable.WeakHashMap[Int, Long]().withDefault(defaultMap)

  val fn: Int => Long = (n: Int) => {
    val result: Long = if (n <= 1) n else fib3(n - 2) + fib3(n - 1)
    cache += n -> result
    result
  }

  def fib3(n: Int): Long = try {
    cache.getOrElse(n, fn(n))
  } catch {
    case soe: StackOverflowError =>
      println(s"StackOverflowError for n=$n")
      sys.exit(1)
  }

  Time.fibTest(fib3, List(10, 42, 42, 50, 100, 500, 1000, 1000)) // arithmetic overflow for values 500 and above
  println(s"Fibonacci of 5000 is: ${fib3(5000)}") // quickly overflows stack
}

object FibWhile extends App {
  def fibWhile(n: Int): Long = {
    var fibn1 = 0L
    var fibn2 = 1L
    (0 until n) foreach { _ =>
      val next = fibn1 + fibn2
      fibn1 = fibn2
      fibn2 = next
    }
    fibn1
  }

  Time.fibTest(fibWhile) // arithmetic overflow for values 500 and above
}

object Fib4 extends App {
  def fib4(n: Int): Long = {
    @tailrec
    def fibIter(count: Int, fibN1: Long, fibN2: Long): Long =
      if (count == n) fibN1
      else fibIter(count + 1, fibN2, fibN1 + fibN2)

    fibIter(0, 0L, 1L)
  }

  Time.fibTest(fib4) // arithmetic overflow for values 500 and above
}

object Fib extends App {
  def fib(n: Int): BigInt = {
    @tailrec
    def fibIter(count: BigInt, fibN1: BigInt, fibN2: BigInt): BigInt =
      if (count == BigInt(n)) fibN1
      else fibIter(count + 1, fibN2, fibN1 + fibN2)

    fibIter(0, BigInt(0), BigInt(1))
  }

  Time.fibTest(fib)
  // println(s"Fibonacci of -10  is: ${fib(-10)}")  Will run forever
}

object FibCheck extends App {
  import scala.util.Try

  def fibMask(n: Int): BigInt = {
    @tailrec
    def fibIter(count: Int, fibN1: BigInt, fibN2: BigInt): BigInt =
      if (count == math.abs(n)) fibN1
      else fibIter(count + 1, fibN2, fibN1 + fibN2)

    fibIter(0, 0L, 1L)
  }

  def fibThrow(n: Int): BigInt = {
    @tailrec
    def fibIter(count: Int, fibN1: BigInt, fibN2: BigInt): BigInt =
      if (count == n) fibN1
      else fibIter(count + 1, fibN2, fibN1 + fibN2)

    require(n >= 0)
    fibIter(0, 0L, 1L)
  }

  def fibTry(n: Int) = Try(fibThrow(n))

  def tryHandler(n: Int) =
    fibTry(n) match {
      case Success(result) =>
        println(s"Fibonacci of $n is: $result [fibTry]")

      case Failure(e) =>
        println(s"Fibonacci of $n is undefined due to '${e.getMessage}' [fibTry]")
    }

  println(s"Fibonacci of 100  is: ${fibMask(100)} [fibMask]")
  println(s"Fibonacci of -10  is: ${fibMask(-10)} [fibMask]")
  // println(s"Fibonacci of -10  is: ${fibThrow(-10)} [fibThrow]") // throws: IllegalArgumentException: requirement failed
  println(s"Fibonacci of 100  is: ${fibTry(100).getOrElse(-1)} [fibTry]")
  println(s"Fibonacci of -10  is: ${fibTry(-10).getOrElse(-1)} [fibTry]")
  println(s"Fibonacci of -10  is: ${fibTry(-10).map(r => r)} [fibTry]")
  tryHandler(100)
  tryHandler(-20)
}

object FibMem extends App {
  val defaultMap = immutable.HashMap(0 -> BigInt(0), 1 -> BigInt(1))
  val cache = mutable.WeakHashMap[Int, BigInt]().withDefault(defaultMap)

  def fn(n: Int): BigInt = {
    @tailrec
    def fibIter(count: Int, fibN1: BigInt, fibN2: BigInt): BigInt =
      if (count == n) {
        cache += n -> fibN1
        fibN1
      }
      else fibIter(count + 1, fibN2, fibN1 + fibN2)

    fibIter(0, 0L, 1L)
  }

  def fibMem(n: Int): BigInt = cache.getOrElse(n, fn(n))

  Time.fibTest(fibMem)
}

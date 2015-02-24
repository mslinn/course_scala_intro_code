package solutions

import scala.annotation.tailrec

object Time2 {
  def timeAndValue(n: Int, fn: Int => Any): (Long, Any) = {
    val s = System.currentTimeMillis
    val result = fn(n)
    (System.currentTimeMillis - s, result)
  }

  def printTiming(n: Int, fn: Int => Any, msg: String): Unit = {
    val result = timeAndValue(n, fn)
    println(f"[It took: ${result._1}%5d ms to run] " + f"$msg $n%6d is: ${result._2}")
  }

  def factTest(fn: Int => Any, values: List[Int] = List(0, 1, 2, 3, 10, 42, 50, 100, 500, 1000, 1000, 5000, 5000)) =
    values.map(n => printTiming(n, fn, "Factorial of: "))

}

object Fact1 extends App {
  def fact1(n: Int): BigInt = {
    require(n >= 0)
    if (n == 0) 1
    else fact1(n - 1) * n
  }

  Time2.factTest(fact1)
}

object FactLoop extends App {
  def factLoop(n: Int): BigInt = {
    require(n >= 0)
    var factAccum = BigInt(1)
    (1 to n) foreach { i =>
      factAccum *= i
    }
    factAccum
  }

  Time2.factTest(factLoop)
}

object Fact extends App {
  def fact(n: Int): BigInt = {
    @tailrec
    def factIter(counter: Int, factAccum: BigInt): BigInt = {
      if (counter >= n) factAccum
      else factIter(counter + 1, factAccum * (counter + 1))
    }

    require(n >= 0)
    factIter(0, BigInt(1))
  }

  Time2.factTest(fact)
}

object FactMem extends App {
  import scala.collection.{immutable, mutable}

  val defaultMap = immutable.HashMap(0 -> BigInt(1), 1 -> BigInt(1))
  val cache = mutable.WeakHashMap[Int, BigInt]().withDefault(defaultMap)

  def factMem(n: Int): BigInt = {
    @tailrec
    def factIter(counter: Int, factAccum: BigInt): BigInt = {
      if (counter >= n) {
        cache += n -> factAccum
        factAccum
      }
      else factIter(counter + 1, factAccum * (counter + 1))
    }

    require(n >= 0)
    cache.getOrElse(n, factIter(0, BigInt(1)))
  }

  Time2.factTest(factMem)
}

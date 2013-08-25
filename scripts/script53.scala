println("Hello, world!")
val x = 3
val x: Int = 3
var y = 4
y = 36
def timesTwo(x: Int) = 2 * x
timesTwo(21)
def timesTwo(x: Int): Int = 2 * x
1 to 3
1.to(3)
scala.collection.immutable.Range.inclusive(1, 3)
import scala.collection.immutable.Range
Range.inclusive(1, 3)
import scala.collection.immutable.Range.inclusive
inclusive(1, 3)
import scala.collection.immutable.Range._
1 to 3 foreach { i => println("Hello, world!") }
(1 to 3) foreach { i => println("Hello, world!") }
(1 to 3).foreach { i => println("Hello, world!") }
Range.inclusive(1, 3).foreach { i => println("Hello, world!") }
1 to 3 foreach { i => println("Hello, world #" + i) }
1 to 3 foreach { i => println(s"Hello, world #$i") }

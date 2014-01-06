object PureTrait extends App {
  import java.sql.Date

  trait Checkable { def preFlight: Boolean }

  class Course(
    startDate: Date = new Date(System.currentTimeMillis),
    val preFlight: Boolean = false
  ) extends Checkable {
    override val toString = s"startDate=$startDate, preFlight=$preFlight"
  }

  def isReady(checkable: Checkable): Boolean = checkable.preFlight

  val course1 = new Course(Date.valueOf("2014-01-01"), true)
  val course2 = new Course()
  println(s"course1: $course1")
  println(s"isReady(course1): ${isReady(course1)}")
  println()
  println(s"course2: $course2")
  println(s"isReady(course2): ${isReady(course2)}")
}


object ImplementedTrait extends App {
  import java.sql.Date

  trait Checkable { def preFlight: Boolean }

  trait HasId { def id: Long = 0L }

  class Lecture(
    override val id: Long = 0L,
    startDate: Date = Date.valueOf("2014-01-01"),
    val preFlight: Boolean = false
  ) extends Checkable with HasId {
      override val toString = s"id=$id, startDate=$startDate, preFlight=$preFlight"
    }


  def isReady(checkable: Checkable): Boolean = checkable.preFlight

  val lecture1 = new Lecture(1L, preFlight=true)
  val lecture2 = new Lecture()
  println(s"lecture1: $lecture1")
  println(s"isReady(lecture1): ${isReady(lecture1)}")
  println()
  println(s"lecture2: $lecture2")
  println(s"isReady(lecture2): ${isReady(lecture2)}")
}


object BoldlyGo extends App {
  val explorer = new Explorer
  println(explorer)

  abstract class Spacecraft { def engage(): Unit }

  trait Bridge {
    def speedUp(): Unit
    def engage(): Unit = { speedUp(); speedUp(); speedUp() }
  }

  trait Engine { def speedUp() }

  trait PulseEngine extends Engine {
    var currentPulse = 0
    def maxPulse: Int
    def speedUp(): Unit = if (currentPulse < maxPulse) currentPulse += 1
  }

  trait ControlCabin {
    def increaseSpeed()
    def engage() = increaseSpeed()
  }

  class Shuttle extends Spacecraft with ControlCabin with PulseEngine {
    val maxPulse = 10
    def increaseSpeed() = speedUp()
  }

  trait WarpEngine extends Engine {
    def maxWarp: Int
    var currentWarp: Int = 0
    def toWarp(x: Int): Unit = if (x < maxWarp) currentWarp = x
  }

  class Explorer extends Spacecraft with Bridge with WarpEngine {
    val maxWarp = 10
    def speedUp(): Unit = toWarp(currentWarp + 1)
  }

  object Defiant extends Spacecraft with ControlCabin with WarpEngine {
    val maxWarp = 20
    def increaseSpeed() = toWarp(10)
    def speedUp(): Unit = toWarp(currentWarp + 2)
  }
}


object ExtendJavaSet extends App {
  trait IgnoredCaseSet extends java.util.Set[String] {
    abstract override def add(str: String) = super.add(str.toLowerCase)

    abstract override def contains(obj: Object) =
      obj match {
        case s: String =>
          super.contains(s.toLowerCase)

        case o =>
          super.contains(o)
      }
  }

  class MySet extends java.util.HashSet[String] with IgnoredCaseSet

  val mySet = new MySet() // Java sets are mutable, only the reference is immutable
  mySet.add("One")
  mySet.add("Two")
  mySet.add("Three")
  println(s"mySet=$mySet")
}


object Tweeters extends App {
  trait User { def name: String }

  trait Tweeter extends User {
    def tweet(msg: String) = println(s"$name: $msg")
  }

  trait Tweeter2 { self: User =>
    def tweet(msg: String) = println(s"${self.name}: $msg")
    def tweet2(msg: String) = println(s"$name:$msg")
  }

  class Blabber(val name: String) extends Tweeter

  val blabber = new Blabber("Mr. Itoktumuch")
  blabber.tweet("tweet tweet tweet")

  class Blabber2(override val name: String) extends Tweeter2 with User

  val blabber2 = new Blabber2("Ms. Nufsaid")
  blabber2.tweet2("Le tweet")
  blabber2.tweet("Une autre tweet")
}

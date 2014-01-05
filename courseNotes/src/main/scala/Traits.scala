object PureTrait extends App {
  import java.sql.Date

  trait Checkable { def preFlight: Boolean }

  class Course(
    startDate: Date = new Date(System.currentTimeMillis),
    override val preFlight: Boolean = false
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

  trait HasId { def id: Option[Long] = None }

  class Lecture(
    override val id: Option[Long] = None,
    startDate: Date = Date.valueOf("2014-01-01"),
    override val preFlight: Boolean = false
  ) extends Checkable with HasId {
      override val toString = s"id=$id, startDate=$startDate, preFlight=$preFlight"
    }


  def isReady(checkable: Checkable): Boolean = checkable.preFlight

  val lecture1 = new Lecture(Some(1), preFlight=true)
  val lecture2 = new Lecture()
  println(s"lecture1: $lecture1")
  println(s"isReady(lecture1): ${isReady(lecture1)}")
  println()
  println(s"lecture2: $lecture2")
  println(s"isReady(lecture2): ${isReady(lecture2)}")
}


object BoldlyGo extends App {
  val x = new Explorer
  println (x)

  abstract class Spacecraft { def engage: Unit }

  trait Bridge {
    def speedUp: Unit
    def engage: Unit = 1 to 3 foreach { _ => speedUp }
  }

  trait Engine { def speedUp }

  trait PulseEngine extends Engine {
    var currentPulse = 0;
    def maxPulse: Int

    def speedUp: Unit = if (currentPulse < maxPulse) currentPulse += 1
  }

  trait ControlCabin {
    def increaseSpeed
    def engage = increaseSpeed
  }

  class Shuttle extends Spacecraft with ControlCabin with PulseEngine {
    val maxPulse = 10
    def increaseSpeed = speedUp
  }

  trait WarpEngine extends Engine {
    object X {
      def blah = "x"
    }
    def maxWarp: Int
    var currentWarp: Int = 0

    def toWarp( x: Int ): Unit = if (x < maxWarp) currentWarp = x
  }

  class Explorer extends Spacecraft with Bridge with WarpEngine {
    val maxWarp = 10

    def blah = "haha"

    def speedUp: Unit = toWarp(currentWarp + 1)
  }

  object Defiant extends Spacecraft with ControlCabin with WarpEngine {
    val maxWarp = 20

    def blah = "haha"

    def increaseSpeed = toWarp(10)

    def speedUp: Unit = toWarp(currentWarp + 2)
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

  class XX extends java.util.HashSet[String] with IgnoredCaseSet
  val xx = new XX() // Java sets are mutable, only the reference is immutable
  xx.add("One")
  xx.add("Two")
  xx.add("Three")
  println(s"xx=$xx")
}

object Tweeters extends App {
  trait User{ def name:String }

  trait Tweeter extends User {
    def tweet(msg:String)=println(s"$name:$msg")
    name
  }

  trait Tweeter2 { self: User =>
    def tweet(msg:String)=println(s"${self.name}:$msg")
    def tweet2(msg:String)=println(s"$name:$msg")
  }

  case class Blabber(name:String) extends Tweeter

  val blabber = Blabber("qwer")
  blabber.tweet("asdf")

  case class Blabber2(name:String) extends Tweeter2 with User

  val blabber2 = Blabber2("kdkdk")
  blabber2.tweet2("ieie")
  blabber2.tweet("ueueu")
}

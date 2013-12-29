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

object BoldlyGo extends App {
  val x = new Explorer
  println (x)
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
  val x = new XX() // Java sets are mutable, only the reference is immutable
  x.add("One")
  x.add("Two")
  x.add("Three")
  println(s"x=$x")
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
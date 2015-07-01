object WhichTrait extends App {
  trait Color {
    def color: String = "Unknown"
    def paint(highlight: String): String = s"$color with $highlight highlights"
  }

  trait Red extends Color {
    override val color: String = "red"
    override def paint(highlight: String): String = super.paint(s"pink and $highlight")
  }

  trait White extends Color {
    override val color: String = "white"
    override def paint(highlight: String): String = super.paint(s"light yellow and $highlight")
  }

  trait Blue extends Color {
    override val color: String = "blue"
    override def paint(highlight: String): String = super.paint(s"bluegreen and $highlight")
  }

  val red = new Red{}
  println(s"""red.paint=${red.paint("polkadot")}""")

  val redWhite = new Red with White
  println(s"""redWhite.paint=${redWhite.paint("polkadot")}""")

  val redWhiteBlue = new Red with White with Blue
  println(s"""redWhiteBlue.paint=${redWhiteBlue.paint("polkadot")}""")

  class Concrete extends Red with White with Blue
  val concrete = new Concrete
  println(s"""concrete.paint=${concrete.paint("polkadot")}""")
}


object ExtendJavaSet extends App {
  trait IgnoredCaseSet extends java.util.Set[Object] {
    abstract override def add(obj: Object): Boolean =
      obj match {
        case s: String => super.add(s.toLowerCase)
        case _ => super.add(obj)
      }


    abstract override def contains(obj: Object): Boolean =
      obj match {
        case s: String => super.contains(s.toLowerCase)
        case _ => super.contains(obj)
      }
  }

  class MySet extends java.util.HashSet[Object] with IgnoredCaseSet

  val mySet = new MySet() // Java sets are mutable, only the reference is immutable
  mySet.add("One")
  mySet.add("Two")
  mySet.add("Three")
  println(s"mySet=$mySet")
  println(s"""mySet.contains("two")=${mySet.contains("two")}""")
}


object Tweeters extends App {
  trait User { def name: String }

  trait Tweeter extends User {
    def tweet(msg: String): Unit = println(s"$name: $msg")
  }

  trait Tweeter2 { self: User =>
    def tweet(msg: String): Unit = println(s"${self.name}: $msg")
    def tweet2(msg: String): Unit = println(s"$name: $msg")
  }

  class Blabber(val name: String) extends Tweeter

  val blabber = new Blabber("Mr. Itoktumuch")
  blabber.tweet("tweet tweet tweet")

  class Blabber2(override val name: String) extends Tweeter2 with User

  val blabber2 = new Blabber2("Ms. Nufsaid")
  blabber2.tweet2("Le tweet")
  blabber2.tweet("Une autre tweet")
}

object HeirGround extends App {
  trait Base { val param1: Int }
  abstract class First(val param2: String)
  case class Holder(override val param1: Int, override val param2: String) extends First(param2) with Base

  val bottles: Holder = new Holder(99, "Bottles of beer")
  val base: Base = bottles
  val first: First = bottles
  println(s"base.param1: ${base.param1}")
  println(s"first.param2: ${first.param2}")
  println(s"bottles: $bottles")
}

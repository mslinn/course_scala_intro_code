object WhichTrait extends App {
  trait Color {
    def color: String = "Unknown"
    def paint(highlight: String): String = s"$color with $highlight highlights"
  }

  trait Red extends Color {
    abstract override val color: String = "red"
    abstract override def paint(highlight: String): String = super.paint(s"pink and $highlight")
  }

  trait White extends Color {
    abstract override val color: String = "white"
    abstract override def paint(highlight: String): String = super.paint(s"light yellow and $highlight")
  }

  trait Blue extends Color {
    abstract override val color: String = "blue"
    abstract override def paint(highlight: String): String = super.paint(s"bluegreen and $highlight")
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
      if (obj.isInstanceOf[String]) super.add(obj.asInstanceOf[String].toLowerCase) else super.add(obj)


    abstract override def contains(obj: Object): Boolean =
      if (obj.isInstanceOf[String]) super.contains(obj.asInstanceOf[String].toLowerCase) else super.contains(obj)
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

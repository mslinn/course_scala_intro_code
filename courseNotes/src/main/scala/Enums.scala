object JavaEnum extends App {
  import Day._
  val day = Day.MONDAY
  if (day==Day.TUESDAY) println("Wimpy wants a hamburger")
  Day.valueOf("MONDAY")

  def tellItLikeItIs(theDay: Day): Unit = {
    val msg = theDay match {
      case MONDAY => "Mondays are bad."
      case FRIDAY => "Fridays are better."
      case SATURDAY => "Weekends are best."
      case SUNDAY => "Weekends are best."
      case _ => "Midweek days are so-so."
    }
    println(msg)
  }
  tellItLikeItIs(MONDAY)
  tellItLikeItIs(TUESDAY)
  tellItLikeItIs(FRIDAY)
  tellItLikeItIs(SUNDAY)
}

object ScalaEnum extends App {
  object ScalaDay extends Enumeration {
    type ScalaDay = Value
    val Monday    = Value("MONDAY")
    val Tuesday   = Value("TUESDAY")
    val Wednesday = Value("WEDNESDAY")
    val Thursday  = Value("THURSDAY")
    val Friday    = Value("FRIDAY")
    val Saturday  = Value("SATURDAY")
    val Sunday    = Value("SUNDAY")
  }
  val Mon = ScalaDay.withName("WEDNESDAY")
  val label = ScalaDay.Friday.toString

  import ScalaDay._
  def tellItLikeItIs(theDay: ScalaDay): Unit = {
    val msg = theDay match {
      case Monday => "Mondays are bad."
      case Friday => "Fridays are better."
      case Saturday => "Weekends are best."
      case Sunday => "Weekends are best."
      case _ => "Midweek days are so-so."
    }
    println(msg)
  }
  tellItLikeItIs(Monday)
  tellItLikeItIs(Tuesday)
  tellItLikeItIs(Wednesday)
  tellItLikeItIs(Sunday)

  object Colors extends Enumeration {
   val Red, Blue, Green = Value
  }

  object Methods {
    //def myMethod(x: Colors.Value)  = "That's a color"
    //def myMethod(x: ScalaDay.Value) = "That's a weekday"
  }
}

object ScalaEnumCase extends App {
  sealed trait CaseDay
  object CaseDay {
    case object Monday extends CaseDay
    case object Tuesday extends CaseDay
    case object Wednesday extends CaseDay
    case object Thursday extends CaseDay
    case object Friday extends CaseDay
    case object Saturday extends CaseDay
    case object Sunday extends CaseDay
  }

  import CaseDay._
  def tellItLikeItIs(theDay: CaseDay): Unit = {
    val msg = theDay match {
      case Monday => "Mondays are bad."
      case Friday => "Fridays are better."
      case Saturday => "Weekends are best."
      case Sunday => "Weekends are best."
      case _ => "Midweek days are so-so."
    }
    println(msg)
  }
  tellItLikeItIs(Monday)
  tellItLikeItIs(Tuesday)
  tellItLikeItIs(Wednesday)
  tellItLikeItIs(Sunday)
}

object BlendedEnum extends App {
  import Day._

  trait EnumLike[T] {
    def name: String

    def compareTo(other: Day): Int

    override def equals(other: Object): Boolean = other.equals()

    def hashCode: Int

    def ordinal: Int

    def toString: String

    def values: Array[T]
  }

  sealed class CaseDay(val day: Day) extends EnumLike[CaseDay] {
    import CaseDay._

    lazy val name: String = day.name

    def compareTo(other: Day): Int = day.compareTo(other)

    override lazy val hashCode: Int = day.hashCode

    lazy val ordinal: Int = day.ordinal

    override lazy val toString = day.toString

    lazy val values: Array[CaseDay] = Array(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
  }

  object CaseDay {
    case object Monday extends CaseDay(MONDAY)
    case object Tuesday extends CaseDay(TUESDAY)
    case object Wednesday extends CaseDay(WEDNESDAY)
    case object Thursday extends CaseDay(THURSDAY)
    case object Friday extends CaseDay(FRIDAY)
    case object Saturday extends CaseDay(SATURDAY)
    case object Sunday extends CaseDay(SUNDAY)

    def valueOf(name: String) = Day.valueOf(name)
  }

  import CaseDay._
  def tellItLikeItIs(theDay: CaseDay): Unit = {
    val msg = theDay.ordinal match {
      case Monday.ordinal => "Mondays are bad."
      case Friday.ordinal => "Fridays are better."
      case Saturday.ordinal => "Weekends are best."
      case Sunday.ordinal => "Weekends are best."
      case _ => "Midweek days are so-so."
    }
    println(msg)
  }
  tellItLikeItIs(Monday)
  tellItLikeItIs(Tuesday)
  tellItLikeItIs(Wednesday)
  tellItLikeItIs(Sunday)
}

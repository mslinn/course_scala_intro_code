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

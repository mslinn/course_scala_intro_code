import java.sql.Date
trait Checkable { def preFlight: Boolean }
case class Course(
  startDate: Date = new Date(System.currentTimeMillis),
  override val preFlight: Boolean = false
) extends Checkable
val course1 = Course(new Date(System.currentTimeMillis), false)
val course2 = Course()
course1.asInstanceOf[Checkable]
trait HasId { val id: Option[Long] = None }
case class Lecture(
  override val id: Option[Long] = None,
  date: Date = new Date(System.currentTimeMillis),
  override val preFlight: Boolean = false
) extends Checkable with HasId
val lecture1 = Lecture(Some(1), preFlight=true)
val lecture2 = Lecture()


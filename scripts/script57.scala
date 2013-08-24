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
abstract class Spacecraft { def engage: Unit }
trait Bridge {
  def speedUp: Unit
  def engage: Unit = 1 to 3 foreach { _ => speedUp }
}
trait Engine { def speedUp }
trait PulseEngine extends Engine {
    var currentPulse = 0;
    val maxPulse: Int
 
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
  val maxWarp: Int
  var currentWarp: Int = 0
 
  def toWarp( x: Int ): Unit = if (x < maxWarp) currentWarp = x
}
class Explorer extends Spacecraft with Bridge with WarpEngine {
    val maxWarp = 10
 
    def speedUp: Unit = toWarp(currentWarp + 1)
}
object Defiant extends Spacecraft with ControlCabin with WarpEngine {
  val maxWarp = 20
 
  def increaseSpeed = toWarp(10)

  def speedUp: Unit = toWarp(currentWarp + 2)
}
trait User { def name: String }
trait Tweeter { user: User => def tweet(msg: String) = println(s"$name: $msg") }
case class Blabber(name: String) extends User with Tweeter


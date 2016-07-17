package animals

class UselessAnimal(numLegs: Int, breathesAir: Boolean)


object ConcreteClasses extends App {
  class UsefulAnimal(numLegs: Int, breathesAir: Boolean) {
    val property1 = s"I have $numLegs legs"

    def walk(n: Int) = (if (numLegs==0) "slither "
                        else if (numLegs==1) "hop "
                        else if (numLegs==2) "stomp "
                        else if (numLegs==4) "gallop "
                        else "crawl ") * n

    def sing = if (breathesAir) "La di da!" else "You must be joking!"
  }

  val monkey = new UsefulAnimal(2, true)
  println(s"monkey.property1=${monkey.property1}")
  println(s"monkey.walk(3)=${monkey.walk(3)}")
  println(s"monkey.sing=${monkey.sing}")

  val fish = new UsefulAnimal(0, false)
  println(s"fish.property1=${fish.property1}")
  println(s"fish.walk(4)=${fish.walk(4)}")
  println(s"fish.sing=${fish.sing}")
}


abstract class BadAnimal(numLegs: Int, breathesAir: Boolean) {
  val x = 3 // part of primary constructor
  println(breathesAir) // part of primary constructor

  def whatAmI = s"$breathesAir;$numLegs legs"

  def anAbstractMethod(param: Int): String

  val y = 3 // part of primary constructor
}

abstract class Animal(numLegs: Int, breathesAir: Boolean) {
  private val breatheMsg = if (breathesAir) "" else " do not"
  val msg = s"I have $numLegs legs and I$breatheMsg breathe air"
}

class Frog1(var canSwim: Boolean, numLegs: Int, val breathesAir: Boolean) extends Animal(numLegs, breathesAir)

object Animals1 extends App {
  val frog = new Animal(4, true) { val canSwim: Boolean = true }
  println(s"frog.msg=${frog.msg}")

  val frog1 = new Frog1(true, 4, true)
  println(s"frog1.canSwim=${frog.canSwim}")
}


class Frog2(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean) extends Animal(numLegs, breathesAir) {
  override def toString = s"Frog2 canSwim=$canSwim, numLegs=$numLegs, breathesAir=$breathesAir"
}

object Animals2 extends App {
  val tadpole = new Frog2(true, 0, false)
  println(s"tadpole.numLegs=${tadpole.numLegs}")
  println(s"tadpole.breathesAir=${tadpole.breathesAir}")
}


object Animals3 extends App {
  val frog2b = new Frog2(true, 4, breathesAir=true)
  val frog2c = new Frog2(true, breathesAir=true, numLegs=4)
  val frog2d = new Frog2(breathesAir=true, numLegs=4, canSwim=true)
  //val frog2e = new Frog2(breathesAir=true, numLegs=4)
  println(s"frog2b=$frog2b")
  println(s"frog2c=$frog2c")
  println(s"frog2d=$frog2d")
}


class Frog3(val canSwim: Boolean, var numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir) {
  override def toString = s"Frog3 canSwim=$canSwim, numLegs=$numLegs, breathesAir=$breathesAir"
}

object Animals4 extends App {
  val frog3 = new Frog3(canSwim=true, 4, breathesAir=true)
  println(s"frog3.numLegs=${frog3.numLegs}")

  frog3.numLegs=5
  println(s"After assignment, frog3.numLegs=${frog3.numLegs}")

  // frog3.canSwim=false

  val frog3b = new Frog3(canSwim=true, 4, breathesAir=true) { override def toString = s"$canSwim; $numLegs legs" }
  println(s"frog3b=$frog3b")
}


class Frog4(val canSwim: Boolean=true, var numLegs: Int=4, breathesAir: Boolean=true) extends Animal(numLegs, breathesAir) {
  override def toString = s"canSwim: $canSwim; $numLegs legs; breathesAir:$breathesAir"
}

object Animals5 extends App {
  val frog4a = new Frog4
  val frog4b = new Frog4(numLegs=2)
  val frog4c = new Frog4(false)
  val frog4d = new Frog4(false, breathesAir=false)

  println(s"frog4a=$frog4a")
  println(s"frog4b=$frog4b")
  println(s"frog4c=$frog4c")
  println(s"frog4d=$frog4d")
}


class Frog5(val canSwim: Boolean, var numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir) {
  override def toString = s"canSwim: $canSwim; $numLegs legs; breathesAir: $breathesAir"
}

object Animals6 extends App {
   val frog5 = new Frog5(canSwim=true, 4, breathesAir=true)
   println(s"frog5=$frog5")
}

object VarArgsScala extends App {
  import java.awt.{Polygon, Point}

  /** @return a polygon connecting the given points */
  def polygonFrom(points: Point*): Polygon = {
    val polygon = new Polygon()
    points.foreach { point => polygon.addPoint(point.x, point.y) }
    polygon
  }

  val square = polygonFrom(new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0))
  println(s"Bounding box of polygon is: ${square.getBounds2D}")

  val points = List(new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0))
  val square2 = polygonFrom(points: _*)
  println(s"Bounding box of polygon is: ${square2.getBounds2D}")
}

object Anonymous1 extends App {
  val adhoc = new {
    def test(predicate: Boolean): String = if (predicate) "Yes" else "No"
  }

  println(s"adhoc.test(3>2)=${adhoc.test(3>2)}")
}

object Anonymous2 extends App {
  import java.util.Date

  val myDate = new Date { def dayAfter = new Date(getTime + 1000L*60L*60L*24L) }
  println(s"myDate.dayAfter=${myDate.dayAfter}")
}

object Anonymous3 extends App {
  val grenouille = new Frog4 {
    var favoriteFood = "insects"

    override def toString = super.toString + s"; favorite food=$favoriteFood"
  }

  println(s"grenouille-=$grenouille")
}

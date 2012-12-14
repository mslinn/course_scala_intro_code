package com.micronautics.scalaJava

/** Controlled explicit conversions powered by JavaConverters */
object JavaConvertersDemo extends App {
  import scala.collection.JavaConverters._

  val scalaList: List[Int] = List(1, 2, 3)
  val wrappedScalaList = scalaList.asJava
  println("scalaList.wrappedScalaList has type " + wrappedScalaList.getClass.getName)
  val javaList: java.util.List[Int] = scalaList.asJava
  println("scalaList.wrappedScalaList has type " + javaList.getClass.getName)

  val scalaIterator: scala.collection.Iterator[Int] = scalaList.toIterator
  val javaIterator: java.util.Iterator[Int] = scalaIterator.asJava

}

/** Uncontrolled implicit conversions inflicted by JavaConversions */
object JavaConversionsDemo extends App {
  import scala.collection.JavaConversions._

  val scalaIist: List[Int] = List(1, 2, 3)
  val scalaIterator: scala.collection.Iterator[Int] = scalaIist.toIterator
  val javaIterator: java.util.Iterator[Int] = scalaIterator

}

object Container {
  import scala.collection.JavaConverters._

  def getInstance = this

  val scalaList: List[Int] = List(1, 2, 3)
  val wrappedScalaList = scalaList.asJava
}

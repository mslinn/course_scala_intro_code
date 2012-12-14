package com.micronautics.scalaJava

object ScalaJava extends App {
  val impl: MyInterface = new JavaClass()
  impl.setDouble(123.4) // change property of object, even though it is a val
  println("impl=" + impl)
  println("impl.getInt=" + impl.getInt + "; impl.getDouble=" + impl.getDouble)

  println
  println("JavaClass.CONSTANT=" + JavaClass.CLASS_CONSTANT)

  val javaClass = new JavaClass // Note optional parentheses not used for constructor
  println("javaClass.instanceConstant=" + javaClass.instanceConstant)

  javaClass setInt 99 // Note optional Scala syntax
  println("javaClass=" + javaClass)
  println("javaClass.getInt=" + javaClass.getInt + "; javaClass.getDouble=" + javaClass.getDouble)
  println("JavaClass.compute(3)=" + JavaClass.compute(3))

  var x = javaClass // create a mutable property
  x = new JavaClass // assign a new value to the mutable property
}

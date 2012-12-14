package com.micronautics.training.javaScalaInterop.assignment

object Main extends App {
  val model = Model

  // Using Scala runtime library methods, Write the equivalent of the following in Java:
  val (minors, adults) = model.people partition(_.age < 18)
  println("minors: " + minors.mkString("\n  ", "\n  ", ""))
  println("adults: " + adults.mkString("\n  ", "\n  ", ""))
}
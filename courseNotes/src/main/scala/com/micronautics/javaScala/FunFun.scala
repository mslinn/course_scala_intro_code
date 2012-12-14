package com.micronautics.javaScala

object FunFun {

  // type of function value is inferred, and the return type of the function is inferred
  val hello = (s: String) => s + ", Mike!"

  // type of function value is declared, and the return type of the function is inferred
  val count: (String) => Int = (s: String) => s.length
  // The above is shorthand for:
  //val count: Function1[String, String] = (s: String) => s.length
}

object FunFun2 {

  val hello = new Function1[String, String] {
    def apply(s: String) = s + ", Mike!"
  }

  val count = new Function1[String, Int] {
    def apply(s: String) = s.length
  }
}
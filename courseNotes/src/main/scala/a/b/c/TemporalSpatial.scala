package com.micronautics

class Temporal

package object alternate {
  def doubler(x: Int): Int = x * 2
}

package alternate {
  class Spatial {
    println(s"Spatial's constructor says that doubling 21 gives ${doubler(21)}")
  }
}

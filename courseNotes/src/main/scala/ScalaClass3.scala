// Notice that the package name does not correspond to the directory structure. This is allowed in Scala.

package com.micronautics.scalaIntro

class ScalaClass3(val prop1: Int, var prop2: Double=0.0) {
  val prop3: Int = prop1 * 2;
  var prop4: Double = prop2 * 3.0;
  private[scalaJava] val packagePrivate = "package private"

  def largestProp(other: ScalaClass3): ScalaClass3 =
    if (this.prop1 > prop1) this else other

  override def toString = "prop1=%02d; prop2=%.1f; prop3=%02d; prop4=%.1f".
    format(prop1, prop2, prop3, prop4)
}

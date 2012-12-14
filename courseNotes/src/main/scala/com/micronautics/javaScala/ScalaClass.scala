package com.micronautics.javaScala

import reflect.BeanProperty

class GetSetExample {
  private var pn = ""

  def name = pn // getter

  // setters can be called three ways, shown below
  def name_=(n: String) { pn = n } // setter
}

object GetSetDemo {
  val x = new GetSetExample
  x.name_=("fred")   // although this syntax is possible
  x.name_$eq("fred") // and this syntax is also possible
  x.name = "george"  // this syntax is more commonly used
  println(x.name)
}

class GetSetExample2 {
  var name = ""
}

object GetSetDemo2 {
  val x = new GetSetExample2
  x.name_$eq("fred")
  x.name = "george"
  println(x.name)
}

/** Decorating a class constructor argument with val allows Java to access it as a property
  * Decorating with var makes it mutable; THIS VIOLATES FUNCTIONAL PROGRAMMING PRINCIPLES!
  * We only show the var so you can see the how @BeanProperty works. */
class ScalaClass1(val prop1: Int, var prop2: Double) {
  val prop3: Int = prop1 * 2;
  var prop4: Double = prop2 * 3.0;

  def largestProp(other: ScalaClass1): ScalaClass1 =
    if (this.prop1 > prop1) this else other

  override def toString = "prop1=%02d; prop2=%.1f; prop3=%02d; prop4=%.1f".
    format(prop1, prop2, prop3, prop4)
}

/** Decorating a class constructor argument with val allows Java to access it as a property
  * Decorating with var makes it mutable; THIS VIOLATES FUNCTIONAL PROGRAMMING PRINCIPLES!
  * We only show the var so you can see the how @BeanProperty works. */
class ScalaClass2(@BeanProperty val prop1: Int, @BeanProperty var prop2: Double) {
  @BeanProperty val prop3: Int = prop1 * 2;
  @BeanProperty var prop4: Double = prop2 * 3.0;

  def largestProp(other: ScalaClass2): ScalaClass2 =
    if (this.prop1 > prop1) this else other

  override def toString = "prop1=%02d; prop2=%.1f; prop3=%02d; prop4=%.1f".
      format(prop1, prop2, prop3, prop4)
}

class ScalaClass3(val prop1: Int, var prop2: Double=0.0) {
  val prop3: Int = prop1 * 2;
  var prop4: Double = prop2 * 3.0;

  def largestProp(other: ScalaClass3): ScalaClass3 =
    if (this.prop1 > prop1) this else other

  override def toString = "prop1=%02d; prop2=%.1f; prop3=%02d; prop4=%.1f".
    format(prop1, prop2, prop3, prop4)
}

/** Scala implements the trait called `ScalaTrait` as a Java interface named `ScalaTrait`,
 * and an implementation named `ScalaTrait$class`. 
 * Here is the interface: <pre>$ javap ScalaTrait.class
<pre>$ javap ScalaTrait$class
Compiled from "ScalaClass.scala"
public interface com.micronautics.javaScala.ScalaTrait extends scala.ScalaObject{
    public abstract void com$micronautics$javaScala$ScalaTrait$_setter_$i_$eq(int);
    public abstract int i();
    public abstract java.lang.String s();
    public abstract void s_$eq(java.lang.String);
    public abstract java.lang.String truncateS(int);
    public abstract java.lang.String toString();
}</pre>
Here is the implementation class. Note that instead of implementing the interface generated from the trait, 
it defines static methods that accept an instance of the interface and delegate to the instance: 
Compiled from "ScalaClass.scala"
public abstract class com.micronautics.javaScala.ScalaTrait$class extends java.lang.Object{
    public static java.lang.String truncateS(com.micronautics.javaScala.ScalaTrait, int);
    public static java.lang.String toString(com.micronautics.javaScala.ScalaTrait);
    public static void $init$(com.micronautics.javaScala.ScalaTrait);
}</pre> 
* A Scala object that extends a trait adds a few members to the implementation, shown in bold. 
* Note that the object's name ends with a dollar sign:
* <pre>javap ScalaObject$
Compiled from "ScalaClass.scala"
public final class com.micronautics.javaScala.ScalaObject$ extends java.lang.Object 
  implements com.micronautics.javaScala.ScalaTrait {
    <b>public static final com.micronautics.javaScala.ScalaObject$ MODULE$;
    public static {};</b>
    public int i();
    public java.lang.String s();
    public void s_$eq(java.lang.String);
    public void com$micronautics$javaScala$ScalaTrait$_setter_$i_$eq(int);
    public java.lang.String truncateS(int);
    public java.lang.String toString();
}</pre> */
trait ScalaTrait {
  
  /** Setters for vals are illegal, which is why the setter (as displayed by `javap`) 
   * for `i` has this crazy signature - so you will not be tempted to try to invoke it: 
   * <pre>public void com$micronautics$javaScala$ScalaTrait$_setter_$i_$eq(int);</pre> */
  val i: Int = 1 
  var s = "Mutable String"
    
  def truncateS(i: Int) = s.substring(0, math.min(s.length, i))
    
  override def toString = "i=%d; s=%s".format(i, s)
}

/** For Java programs that want to extend a Scala trait, just make a Scala class that extends the trait.
 * The Scala class can be concrete, abstract or a case class. */
class ScalaTraitClass extends ScalaTrait

object ScalaObject extends ScalaTrait

case class ScalaCaseClass(j: Int, s: String) {
  def doubleJ = j * 2

  override def toString = "j=%d; s=%s".format(j, s)
}

object Main extends App {
  GetSetDemo
  GetSetDemo2

  new FunProc().doIt()

  val scalaTrait = new ScalaTrait { s = "Avast, matey!" } // create Scala class from trait by supplying a body
  println("scalaTrait=" + scalaTrait)
  
  val scalaCaseClass = ScalaCaseClass(2, "Ever been to sea?")
  println("scalaCaseClass=" + scalaCaseClass)
  
  val scalaClass1 = new ScalaClass1(1, 2.0)
  println("scalaClass1: " + scalaClass1)
	    
  val scalaClass2 = new ScalaClass2(2, 3.0)
  println("scalaClass with largest prop1: " + scalaClass2.largestProp(scalaClass2))
}
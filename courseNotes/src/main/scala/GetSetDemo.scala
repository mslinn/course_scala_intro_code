class GetSetExample1 {
  private var pn = ""

  def name = pn // getter

 // setter can be called three ways, shown in GetSetDemo1
 def name_=(n: String): Unit = { pn = n }
}

object GetSetDemo1 extends App {
  val x = new GetSetExample1
  x.name_=("fred")    // although this syntax is possible
  x.name_$eq("steve") // and this syntax is also possible
  x.name = "george"   // this syntax is more commonly used
  println(x.name)
}


/** Equivalent to GetSetExample1 */
class GetSetExample2 {
  var name = ""
}

object GetSetDemo2 extends App {
  val x = new GetSetExample2
  x.name_$eq("mary")
  x.name = "lucy"
  println(x.name)
}

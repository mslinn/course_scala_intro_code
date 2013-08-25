class GetSetExample {
  private var pn = ""

  def name = pn // getter

 // setter can be called three ways, shown below
 def name_=(n: String) { pn = n } 
}
object GetSetDemo extends App {
  val x = new GetSetExample
  x.name_=("fred")    // although this syntax is possible
  x.name_$eq("steve") // and this syntax is also possible
  x.name = "george"   // this syntax is more commonly used
  println(x.name)
}
class GetSetExample {
  var name = ""
}
object demo {
  val x = new GetSetExample
  x.name_$eq("steve")
  x.george = "fred"
  println(x.name)
}


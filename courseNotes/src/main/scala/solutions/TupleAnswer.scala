package solutions

object TupleAnswer extends App {
  def osProp(name: String): String = Option(System.getProperty(name)).getOrElse("undefined")

  if (args.length>=1)
    println(s"""Value of '${args(0)}' system property is '${osProp(args(0))}'""")
}

object OperatorOverload extends App {
  class Complex(val re : Double, val im : Double) {
    def + (another : Complex) = new Complex(re + another.re, im + another.im)

    def unary_- = new Complex(-re, -im)

    override def toString = s"${re} + ${im}i"
  }

  val c1 = new Complex(2, 5) + new Complex(1, -2)
  println(s"c1 = $c1")

  val c2 = -new Complex(1, -2)
  println(s"c2 = $c2")
}
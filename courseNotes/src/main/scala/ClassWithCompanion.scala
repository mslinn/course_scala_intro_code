class ClassWithCompanion(val x: Int)

object ClassWithCompanion {
  def apply(x: Int) = new ClassWithCompanion(x)
}

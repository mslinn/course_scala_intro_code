object TypeWidening1 extends App {
  val x: Any = System.currentTimeMillis match {
    case evenMillis if evenMillis % 2 == 0 => true
    case millis if new java.util.Date(millis).toString.contains("Tue ") => "Today is a Tuesday"
    case rightNow => rightNow
  }
  println(s"x has type ${x.getClass.getName} and value $x")
}

object TypeWidening2 extends App {
  val rightNow = System.currentTimeMillis
  val x: Any = if (rightNow % 2 == 0) true else
  if (new java.util.Date(rightNow).toString.contains("Tue ")) "Today is a Tuesday" else rightNow
  println(s"x has type ${x.getClass.getName} and value $x")
}

object DogHog extends App {
  class Dog(val name: String) {
    override def equals(that: Any): Boolean = canEqual(that) && hashCode==that.hashCode

    override def hashCode = name.hashCode

    def canEqual(that: Any) : Boolean = that.isInstanceOf[Dog]
  }

  class Hog(val name: String) {
    override def equals(that: Any): Boolean = canEqual(that) && hashCode==that.hashCode

    override def hashCode = name.hashCode

    def canEqual(that: Any) : Boolean = that.isInstanceOf[Hog]
  }

  val dog = new Dog("Fido")
  val hog = new Hog("Porky")

  println(s"Should a dog be compared to a hog? ${dog.isInstanceOf[Hog]}")
  println(s"Comparing ${dog.name} with ${hog.name} gives: ${dog==hog}")
}

object MaybeDog2 extends App {
  class Dog2(val name: String) {
    override def equals(that: Any): Boolean = canEqual(that) && hashCode==that.hashCode

    override def hashCode = name.hashCode

    def canEqual(that: Any) : Boolean = that.isInstanceOf[Dog2]

    def ===(that: Any): Boolean =
      if (canEqual(that)) this==that else {
        println(s"ERROR: ${getClass.getName} should not be compared to a ${that.getClass.getName}")
        false
      }
  }

  val dog2 = new Dog2("Fido2")
  val maybeDog2 = Some(dog2)
  println(s"Comparing dog2 with maybeDog2: ${dog2===maybeDog2}")
}
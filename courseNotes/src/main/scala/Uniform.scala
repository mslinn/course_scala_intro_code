object Uniform1 extends App {
  class Person1 { val name = "Fred Flintstone" }
  val person1 = new Person1
  println(person1.name)

  class Person2 { def name = "Wilma Flintstone" }
  val person2 = new Person2
  println(person2.name)
}


object Uniform2 extends App {
  abstract class AbstractPerson {
    def name: String
    def printName() = println(name)
  }

  class Person3 extends AbstractPerson { val name = "Jumping Jack Flash" }

  val person3 = new Person3
  person3.printName

  class Person4 extends AbstractPerson { var name = "Jane Danger" }

  val person4 = new Person4
  person4.printName
}
val x = 42
x = 2
var y = 42
y = 3
def echo(what: String): Unit = println(what)
echo("Hi there!")
class Person1 { val name = "Fred Flintstone" }
val person1 = new Person1
println(person1.name)
class Person2 { def name = "Fred Flintstone" }
val person2 = new Person2
println(person2.name)
abstract class AbstractPerson {
  def name: String
  def printName() = println(name)
}
class Person3 extends AbstractPerson { val name = "Jumping Jack Flash" }
val person3 = new Person3
person3.printName
abstract class AbstractPerson2 {
  def name: String
  def printName() = println(name)
}
class Person4 extends AbstractPerson2 { var name = "Jane Danger" }
val person4 = new Person4
person4.printName



case class Dog(name: String) {
  override def equals(that: Any): Boolean = canEqual(that) && hashCode==that.hashCode
  override def hashCode = name.hashCode
}
class Stick
implicit class DogCommands(dog: Dog) {
  def call(me: String): String = s"Here, ${dog.name} come to $me"
  def fetch(stick: Stick): String = s"${dog.name}, fetch the stick!"
  def fetch(ball: Ball): String = s"${dog.name}, fetch the ${ball.color} ball!"  
}
val dog = Dog("Fido")
dog.call("me")
dog.fetch(new Stick)
val ball = new Ball("green")
dog.fetch(ball)


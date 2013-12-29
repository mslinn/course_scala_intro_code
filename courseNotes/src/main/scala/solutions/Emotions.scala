package solutions

object Emotions extends App {

  class Person(val name: String) {
    def speak(feelings: String): Unit = println(feelings)
  }

  trait Angry { self: Person =>
    def growl = self.speak(s"$name is having a bad day")
  }

  trait Happy { self: Person =>
    def laugh = self.speak(s"$name is happy")
  }

  // Solution 1:
  (new Person("Fred Flintstone") with Angry).growl
  (new Person("Wilma Flintstone") with Angry with Happy).laugh

  // Solution 2:
  class AngryPerson(override val name: String) extends Person(name) with Angry
  class HappyPerson(override val name: String) extends Person(name) with Happy
  new AngryPerson("Bambam Rubble").growl
  new HappyPerson("Pebbles Flintstone").laugh
}

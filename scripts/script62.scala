val x = "b"
x match {
  case "a" => 1
  case "b" => 2
  case "c" => 3
  case _ => 0
}
abstract class Animal(numLegs: Int, breathesAir: Boolean) {
  private val breatheMsg = if (breathesAir) "" else " do not"
  val msg = s"I have $numLegs legs and I $breatheMsg breathe air" 
}
case class Frog(canSwim: Boolean, numLegs: Int, breathesAir: Boolean) extends Animal(numLegs, breathesAir)
case class Dog(barksTooMuch: Boolean) extends Animal(4, true)
def classify(animal: Animal): Unit = animal match {
  case frog: Frog => 
    println(s"Got a Frog with ${frog.numLegs} legs; canSwim=${frog.canSwim} and breathesAir=${frog.breathesAir}")

  case dog: Dog => 
    println(s"Got a Dog and $barksTooMuch=${dog.barksTooMuch}")

  case x => 
    println(s"Got an unexpected animal $x")
}
val frog1 = Frog(canSwim=true, 4, breathesAir=true)
classify(frog1)
val tadpole = Frog(canSwim=true, 0, breathesAir=false)
classify(tadpole)
val bigDog = Dog(barksTooMuch=false)
classify(bigDog)
val yapper = Dog(barksTooMuch=true)
classify(yapper)
def extract(animal: Animal): Unit = animal match {
  case Frog(canSwim, numLegs, breathesAir) => 
    println(s"Got a Frog with $numLegs legs; canSwim=$canSwim and breathesAir=$breathesAir")

  case Dog(barksTooMuch) => 
    println(s"Got a Dog and barksTooMuch=$barksTooMuch")

  case x => 
    println(s"Got an unexpected animal $x")
}
extract(tadpole)
extract(bigDog)
extract(yapper)
case class Address(street: String, street2: String, city: String, country: String)
val addresses = List(
  Address("123 Main St", "Apt 3", "Yourtown", "MD"),
  Address("234 Rue Blue", "Apt 5", "Fontaineblue", "France"),
  Address("543 Toulouse", "Apt 6", "Paris", "France")
)
addresses foreach { _ match {
    case address @ Address(_, _, "Paris", "France") => println(address.street)
    case _ =>
  }
}

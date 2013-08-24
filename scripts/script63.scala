case class Dog(name: String)
var dog1 = Dog("Fido")
var dog2 = Dog("Fido")
dog1.canEqual(dog2)
dog1==dog2
case class Dog(name: String) {
    override def equals(that: Any): Boolean = canEqual(that) && (hashCode == that.hashCode)
    
    override def hashCode = name.hashCode
}
var dog1 = Dog("Fido")
var dog2 = Dog("Fido")
dog1==dog2
class Hog(name: String) {
  override def equals(that: Any): Boolean = that.isInstanceOf[Hog] && hashCode==that.hashCode
  override def hashCode = name.hashCode
}


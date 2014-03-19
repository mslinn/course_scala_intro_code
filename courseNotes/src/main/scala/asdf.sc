type Encryptor = (String, Int) => String
class MyClass

implicit val myFavorite: Encryptor = { (string, int) => string.reverse }

class Encrypt(var password: String)(implicit val encryptor: Encryptor) {
  def encrypt = encryptor(password, 3)
}

new Encrypt("hithere")(myFavorite)

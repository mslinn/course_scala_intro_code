object Shrug extends App {
  def `¯⧵_(ツ)_/¯`(msg: String): Nothing = sys.error(s"¯⧵_(ツ)_/¯ $msg")

  def shrug(msg: String): Nothing = sys.error(s"¯⧵_(ツ)_/¯ $msg")

  `¯⧵_(ツ)_/¯`("Oops, I did it again!")
  shrug("Oops, I did it yet again!")
}

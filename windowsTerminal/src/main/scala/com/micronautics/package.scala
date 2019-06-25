package com

package object micronautics {
  def writeTo(path: java.nio.file.Path, content: String): Unit = {
    import java.io.{FileWriter, IOException, Writer}
    val w: Writer = new FileWriter(path.toFile)
    try {
      w.write(content)
      w.close()
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

  def die(errorCode: Int, message: String): Nothing = {
    System.err.println(message)
    sys.exit(errorCode)
  }

  def info(message: String): Unit = System.err.println(message)
}

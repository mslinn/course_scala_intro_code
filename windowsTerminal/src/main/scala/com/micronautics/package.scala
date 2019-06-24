package com

import java.nio.file.{Path, Paths}

package object micronautics {
  def read(path: Path): String = readLines(path).mkString("\n")

  def read(file: java.io.File): String = read(file.toPath)

  def readLines(path: Path): List[String] = using(io.Source.fromFile(path.toFile)) { _.getLines }.toList

  def readLines(file: java.io.File): List[String] = readLines(file.toPath)

  def run(cmdSeq: String*): String = {
    import scala.sys.process._
    Process(cmdSeq).!!.trim
  }

  def using[A <: AutoCloseable, B](resource: A)(block: A => B): B =
    try block(resource) finally resource.close()

  def using[A, B <: AutoCloseable, C <: AutoCloseable](closeable1: B, closeable2: C)
                                                      (f: (B, C) => A): A = {
    import scala.language.reflectiveCalls

    try {
      f(closeable1, closeable2)
    } finally {
      closeable1.close()
      closeable2.close()
    }
  }

  /* Scala 2.13
  import scala.util.Using
  import java.io.{PrintWriter, BufferedReader, FileReader}

  Using.Manager { use =>
    val in  = use(new BufferedReader(new FileReader("input.txt")))
    val out = use(new PrintWriter("output.txt"))
    out.println(in.readLine)
  } */

  def writeTo(pathStr: String, content: String): Unit = writeTo(Paths.get(pathStr), content)

  def writeTo(path: Path, content: String): Unit = {
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

  def quit(errorCode: Int, message: String): Unit = die(errorCode, message)

  def warn(message: String): Unit = System.err.println("Warning: " + message)
}

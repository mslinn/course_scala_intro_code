object Thing1 {
  type Closeable = { def close(): Unit }

  def using[A <: Closeable, B](closeable: A)(f: A => B): B = {
    try {
      f(closeable)
    } finally {
      try {
        closeable.close()
      } catch { case _: Throwable => () }
    }
  }

  val byteStream = new java.io.ByteArrayInputStream("hello world".getBytes)
  using(byteStream){ in => 
    val str = io.Source.fromInputStream(in).mkString
    println(s"$str has ${str.length} characters")
  }
}
object Thing2 {
  type Closeable = { def close(): Unit }

  def using[A <: Closeable, B](closeable: => A)(f: A => B): B = {
    val closeableRef = closeable // only reference closeable once
    try {
      f(closeableRef)
    } finally {
      try {
        closeableRef.close()
      } catch { case _: Throwable => () }
    }
  }

  val byteStream = new java.io.ByteArrayInputStream("hello world".getBytes)
  using(byteStream){ in => 
    val str = io.Source.fromInputStream(in).mkString
    println(s"$str has ${str.length} characters")
  }
}


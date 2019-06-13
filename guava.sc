import $ivy.`com.google.guava:guava:27.1-jre`
import scala.collection.JavaConverters._
import com.google.common.base.Splitter
import java.util.regex.Pattern
val tokenizerPattern: Pattern = Pattern.compile("[ \r\n]")
val lineTH = """.TH man 1 "03 May 2019" "1.0" "cad-lecture man page""""
val lineB: String = """.B Something Else
        |blah
        |""".stripMargin
val split=Splitter.
  on(tokenizerPattern).
  split(lineB).
  asScala.
  toList
  
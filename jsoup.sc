/** Extract title and headings from a URL.
  * Call like this:
  *   amm jsoup.sc */

// See https://jsoup.org/
import $ivy.`org.jsoup:jsoup:1.11.3`

import scala.collection.JavaConverters._
import scala.io.Source._

val html: String = fromURL("https://www.scalacourses.com").mkString
val doc = org.jsoup.Jsoup.parse(html)
val title = doc.select("title").text
println(s"""title="$title"""")

val headings = doc.select("h1, h2, h3, h4, h5, h6, h7").eachText().asScala
println("headings:\n" + headings.mkString("  ", "\n  ", ""))

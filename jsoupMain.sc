/** Extract title and headings from a given URL.
  * Call like this:
  *   amm jsoup.sc https://www.scalacourses.com */

// See https://jsoup.org/
import $ivy.`org.jsoup:jsoup:1.11.3`

def help(msg: String = ""): Nothing = {
  Console.err.println(msg)
  sys.exit(1)
}

@main
def main(args: String*): Unit = {
  if (args.isEmpty) help("Error: No URL was provided.\n")

  import scala.io.Source._
  val html: String = fromURL(args(0)).mkString

  val doc = org.jsoup.Jsoup.parse(html)
  val title = doc.select("title").text
  println(s"""title="$title"""")

  import scala.collection.JavaConverters._
  val headings = doc.select("h1, h2, h3, h4, h5, h6, h7").eachText().asScala
  println("headings:\n" + headings.mkString("  ", "\n  ", ""))
}

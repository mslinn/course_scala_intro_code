import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.micronautics._

trait Constants {
  val file = new java.io.File("/mnt/c/Users/mslinn/AppData/Local/Packages/Microsoft.WindowsTerminal_8wekyb3d8bbwe/RoamingState/profiles.json")
  val json: JsonNode = new ObjectMapper().readTree(file)
}

/** Only runs from Windows Subsystem for Linux, does not run under native Windows */
object WindowsTerminalSize extends App with JQ with Constants {
  val initialCols: String = jq(json, """.globals | .initialCols""").mkString(", ")
  val initialRows: String = jq(json, """.globals | .initialRows""").mkString(", ")
  println(s"initialRows=$initialRows, initialCols=$initialCols")

  val newRows: Int = 55
  val newJson: Seq[JsonNode] = jq(json, s""".globals.initialRows=$newRows""")
  writeTo(file.toPath, newJson.map(_.toString).mkString("\n"))

  val newCols: Int = 150
  val newJson2: Seq[JsonNode] = jq(json, s""".globals.initialCols=$newCols""")
  writeTo(file.toPath, newJson2.map(_.toString).mkString("\n"))
}

/** Only runs from Windows Subsystem for Linux, does not run under native Windows
  * This will update Windows Terminal immediately if running */
object WindowsTerminalCursor extends App with JQ with Constants {
  val ubuntuCursorShape: String = jq(json, s""".profiles[] | select(.name=="Ubuntu") | .cursorShape""").mkString(", ")
  println(s"ubuntuCursorShape=$ubuntuCursorShape")
  val cursorShape = "vintage"
  val query = s""".profiles[] | select(.name=="Ubuntu") | .cursorShape)="$cursorShape""""
  val newJson: Seq[JsonNode] = jq(json, query)
  writeTo(file.toPath, newJson.map(_.toString).mkString("\n"))
}

/** This will update Windows Terminal immediately if running.
  * Only runs from Windows Subsystem for Linux, does not run under native Windows */
object WindowsTerminalColors extends App with JQ with Constants {
  val colorScheme: String = jq(json, s""".profiles[] | select(.name=="Ubuntu") | .colorScheme""").mkString(", ")
  println(s"colorScheme=$colorScheme")
  val newColorScheme = "Solarized Dark"
  val query = s""".profiles[] | select(.name=="Ubuntu") | .colorScheme)="$newColorScheme""""
  val newJson = jq(json, query)
  writeTo(file.toPath, newJson.map(_.toString).mkString("\n"))
}

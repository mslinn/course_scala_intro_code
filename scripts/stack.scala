import scala.collection.mutable.Stack
import scala.annotation.tailrec
val stack = Stack.empty[Char]
def stackIn(line: String): Boolean = {
  val parens: String = line.toSeq.filter { "[](){}".toSeq.contains }.mkString
      
  def prune(l: String): String = l.toString.replaceAll("\\{\\}", "").replaceAll("\\(\\)", "").replaceAll("\\[\\]", "")
  
  @tailrec def reduce(l: String): String = {
    val next = prune(l)
    if (next.length==l.length)
      next
    else
      reduce(next)
  }
  val unbalanced: String = reduce(stack.mkString + line)
  stack.clear
  unbalanced.foreach(stack.push)
  stack.isEmpty
}


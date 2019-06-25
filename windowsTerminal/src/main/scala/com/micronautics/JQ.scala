package com.micronautics

import com.fasterxml.jackson.databind.JsonNode
import net.thisptr.jackson.jq.{JsonQuery, Scope}

trait JQ {
  import scala.jdk.CollectionConverters._

  /** A scope is a nested container for variables and functions. If you don't pass variables
    * or functions defined in Java to jq, you only need a root scope for storing built-in functions. */
  protected lazy val rootScope: Scope = Scope.newEmptyScope()
  rootScope.loadFunctions(classOf[Scope].getClassLoader) // load built-in functions.

  def jq(json: JsonNode, filter: String): List[JsonNode] = {
    if (filter.trim.isEmpty) die(88, "jq - no filter was provided.")
    if (json.toString.trim.isEmpty) die(88, "jq - no JSON was provided.")
    val q: JsonQuery = JsonQuery.compile(filter)
    q.apply(rootScope, json).asScala.toList
  }
}

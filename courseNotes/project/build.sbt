resolvers += "Sonatype releases"  at "https://oss.sonatype.org/content/repositories/releases/"

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

// No compatible version for SBT 1.x available:
//addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("com.orrsella" % "sbt-sublime" % "1.1.2")


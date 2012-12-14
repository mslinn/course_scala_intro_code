organization := "com.micronautics"

name := "Java Scala Interop Course Notes"

version := "0.1"

scalaVersion := "2.9.2"

scalaVersion in update := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-unchecked")

scalacOptions in (Compile, doc) <++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-sourcepath", bd.getAbsolutePath,
     "-doc-source-url", "https://bitbucket.org/mslinn/javaScalaInterop/src/master€{FILE_PATH}.scala"
  )
}

resolvers ++= Seq(
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"
)

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.9.1" % "1.8" % "test" withSources()
)

logLevel := Level.Error

// Optional settings from https://github.com/harrah/xsbt/wiki/Quick-Configuration-Examples follow

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """
"""

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

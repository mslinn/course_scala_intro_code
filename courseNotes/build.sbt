organization := "com.micronautics"

name := "scalaJavaOOCompat"

description := "Scala/Java Interoperability: Object Oriented Compatibility Course Notes"

version := "0.1.0"

scalaVersion := "2.10.0-RC5"

scalacOptions ++= Seq("-deprecation", "-encoding", "UTF-8", "-feature", "-target:jvm-1.6", "-unchecked", "-Ywarn-adapted-args")

scalacOptions in (Compile, doc) <++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-sourcepath", bd.getAbsolutePath,
     "-doc-source-url", "https://bitbucket.org/mslinn/udemy_scalajavainterop_oocompat_code/src/master/courseNotes€{FILE_PATH}.scala"
  )
}

resolvers ++= Seq(
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"
)

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10.0-RC5" % "2.0.M5-B1" % "test" withSources()
)

logLevel := Level.Error

// Optional settings from https://github.com/harrah/xsbt/wiki/Quick-Configuration-Examples follow

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """
"""

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

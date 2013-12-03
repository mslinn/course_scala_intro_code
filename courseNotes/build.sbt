organization := "com.micronautics"

name := "scalaIntroCourse"

description := "Core Scala - Introduction to Scala Course Notes"

version := "0.1.2"

scalaVersion := "2.10.3"

scalacOptions in (Compile, doc) <++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-deprecation", 
	 "-encoding", "UTF-8", 
	 "-unchecked",
     "-feature", 
	 "-target:jvm-1.6", 
     "-sourcepath", bd.getAbsolutePath,
	 "-Ywarn-adapted-args"
  )
}

logLevel := Level.Error

// Optional settings from https://github.com/harrah/xsbt/wiki/Quick-Configuration-Examples follow
initialCommands := """
"""

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

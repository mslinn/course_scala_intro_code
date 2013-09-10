organization := "com.micronautics"

name := "scalaIntroCourse"

description := "Scala Introduction - Course Notes"

version := "0.1.0"

scalaVersion := "2.10.2"

scalacOptions in (Compile, doc) <++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-deprecation", 
	 "-encoding", "UTF-8", 
	 "-unchecked",
     "-feature", 
	 "-target:jvm-1.6", 
     "-sourcepath", bd.getAbsolutePath,
	 "-Ywarn-adapted-args",
     "-doc-source-url", "https://bitbucket.org/mslinn/course_scala_intro_code/src/master/courseNotes€{FILE_PATH}.scala"
  )
}

logLevel := Level.Error

// Optional settings from https://github.com/harrah/xsbt/wiki/Quick-Configuration-Examples follow
initialCommands := """
"""

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

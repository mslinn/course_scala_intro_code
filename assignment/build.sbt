organization := "com.micronautics"

name := "scalaIntroCourse1Assignment"

description := "Scala Introduction - Course1 Assignment"

version := "0.1.0"

scalaVersion := "2.10.0-RC5"

scalacOptions in (Compile, doc) <++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-deprecation", 
	 "-encoding", "UTF-8", 
	 "-unchecked",
     "-feature", 
	 "-target:jvm-1.6", 
     "-sourcepath", bd.getAbsolutePath,
	 "-Ywarn-adapted-args",
     "-doc-source-url", "https://bitbucket.org/mslinn/udemy_scalaintro_couse1_code/src/master/assignment€{FILE_PATH}.scala"
  )
}

logLevel := Level.Error

// Optional settings from https://github.com/harrah/xsbt/wiki/Quick-Configuration-Examples follow
initialCommands := """
"""

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

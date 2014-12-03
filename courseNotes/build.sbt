import sbt.Keys._

organization := "com.micronautics"

name := "scalaIntroCourse"

description := "Core Scala - Introduction to Scala Course Notes"

version := "2.11.4"

scalaVersion := "2.11.4"

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

libraryDependencies ++= Seq(
  "org.specs2"    %% "specs2"    % "2.3.12" % "test" withSources(),
  "org.scalatest" %% "scalatest" % "2.2.0"  % "test" withSources(),
  "junit"         %  "junit"     % "4.11"   % "test" // Scala IDE requires this; IntelliJ IDEA does not
)

updateOptions := updateOptions.value.withCachedResolution(true)

logLevel := Level.Error

// Optional settings from https://github.com/harrah/xsbt/wiki/Quick-Configuration-Examples follow
initialCommands := """
"""

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

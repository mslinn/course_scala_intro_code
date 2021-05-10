val dottyVersion = "3.0.0-RC3"
val scala212Version = "2.12.13"
val scala213Version = "2.13.5"

organization := "com.mslinn"
name := "dotty-cross"
version := dottyVersion

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11"  % Test
)

// To make the default compiler and REPL use Dotty
scalaVersion := dottyVersion

// To cross compile with Dotty and Scala 2
crossScalaVersions := Seq(dottyVersion, scala213Version, scala212Version)

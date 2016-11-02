organization := "com.micronautics"
name := "IntroScalaCourse"
description := "Core Scala - Introduction to Scala Course Notes"
version := "2.12.0"

scalaVersion := "2.11.0" // Scala-IDE is not yet compatible with Scala 2.12
autoCompilerPlugins := true
scalacOptions in (Compile, doc) ++= baseDirectory.map {
  (bd: File) => Seq[String](
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-target:jvm-1.8",
    "-unchecked",
    "-Ywarn-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-unused",
    "-Ywarn-value-discard",
    "-Xfuture",
    "-Xlint"
  )
}.value
scalacOptions in Test ++= Seq("-Yrangepos")

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

libraryDependencies ++= Seq(
  "org.specs2"    %% "specs2-core"  % "3.8.6" % "test" withSources(),
  "org.specs2"    %% "specs2-junit" % "3.8.6" % "test" withSources(),
  "org.scalatest" %% "scalatest"    % "3.0.0" % "test" withSources()
)

triggeredMessage in ThisBuild := Watched.clearWhenTriggered

updateOptions := updateOptions.value.withCachedResolution(true)

// set the initial commands when entering 'console' or 'consoleQuick', but not 'consoleProject'
initialCommands in console := """import java.io.File
                                |import scala.language.postfixOps
                                |import java.net.URL
                                |import scala.util.control.NoStackTrace
                                |import scala.util.{Try,Success,Failure}
                                |""".stripMargin

logLevel := Level.Info
logLevel in test := Level.Info // Level.Info is needed to see detailed output when running tests
logLevel in compile := Level.Info

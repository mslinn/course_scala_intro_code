organization := "com.micronautics"
name := "intro-scala-course"
description := "Core Scala - Introduction to Scala Course Notes"
version := "2.12.5"

scalaVersion := "2.12.5"
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
  "org.specs2"    %% "specs2-core"  % "4.0.3-83f81a8-20180227163433" % "test" withSources(),
  "org.specs2"    %% "specs2-junit" % "4.0.3" % "test" withSources(),
  "org.scalatest" %% "scalatest"    % "3.0.5" % "test" withSources(),
  "junit"         %  "junit"        % "4.12"  % "test"
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

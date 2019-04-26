organization := "com.micronautics"
name := "intro-scala-course"
description := "Core Scala - Introduction to Scala Course Notes"

scalaVersion := "2.12.8"   // comment this line to use Scala 2.13-RC1
//scalaVersion := "2.13.0-RC1" // uncomment this line to use Scala 2.13-RC1
version := scalaVersion.value

autoCompilerPlugins := true
scalacOptions in (Compile, doc) ++= baseDirectory.map {
  bd: File => Seq[String](
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
  "org.specs2"    %% "specs2-core"  % "4.5.1" % Test withSources(),
  "org.specs2"    %% "specs2-junit" % "4.5.1" % Test withSources(),
  "org.scalatest" %% "scalatest"    % "3.0.5" % Test withSources(),
  "junit"         %  "junit"        % "4.12"  % Test
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

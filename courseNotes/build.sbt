organization := "com.micronautics"
name := "intro-scala-course"
description := "Core Scala - Introduction to Scala Course Notes"

//scalaVersion := "2.12.13"     // Comment this line to use Scala 2.13
scalaVersion := "2.13.5"   // Uncomment this line to use Scala 2.12
version := scalaVersion.value

autoCompilerPlugins := true
Compile / doc / scalacOptions ++= baseDirectory.map {
  bd: File => Seq[String](
    "-encoding", "UTF-8",
    "-feature",
    "-target:jvm-1.8",
    "-unchecked",
    "-Ywarn-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xlint"
  )
}.value
Test / scalacOptions ++= Seq("-Yrangepos")
scalacOptions += "-deprecation"

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

val specsVer = "4.11.0"
libraryDependencies ++= Seq(
  "org.specs2"    %% "specs2-core"  % specsVer % Test withSources(),
  "org.specs2"    %% "specs2-junit" % specsVer % Test withSources(),
  "org.scalatest" %% "scalatest"    % "3.2.7"  % Test withSources(),
  "junit"         %  "junit"        % "4.12"   % Test
)

ThisBuild  / watchBeforeCommand := Watch.clearScreen

ThisBuild / turbo := true

updateOptions := updateOptions.value.withCachedResolution(true)

// set the initial commands when entering 'console' or 'consoleQuick', but not 'consoleProject'
initialCommands / console := """import java.io.File
                                |import scala.language.postfixOps
                                |import java.net.URL
                                |import scala.util.control.NoStackTrace
                                |import scala.util.{Try,Success,Failure}
                                |""".stripMargin

logLevel := Level.Info
Test / logLevel := Level.Info    // Level.Info is needed to see detailed output when running tests
Compile / logLevel := Level.Info // Redundant but provided so students can adjust separately

Global / excludeLintKeys += Compile / logLevel
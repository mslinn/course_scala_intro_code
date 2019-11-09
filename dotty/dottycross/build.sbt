val dottyVersion = "0.20.0-RC1"
val scala212Version = "2.12.10"
val scala213Version = "2.13.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-cross",
    version := "0.1.1",

    libraryDependencies ++= Seq(
      "com.micronautics" %% "awslib_scala"    % "1.1.13" withSources(),
      "com.novocode"     %  "junit-interface" % "0.11"  % Test
    ).map(_.withDottyCompat(scalaVersion.value)),

    resolvers += "micronautics/scala on bintray" at "https://dl.bintray.com/micronautics/scala",

    // To make the default compiler and REPL use Dotty
    scalaVersion := dottyVersion,

    // To cross compile with Dotty and Scala 2
    crossScalaVersions := Seq(dottyVersion, scala213Version, scala212Version)
  )

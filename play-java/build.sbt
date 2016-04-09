import play.ebean.sbt.PlayEbean

name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.5.0",
  "org.webjars" % "bootstrap" % "3.3.6",
  "org.webjars" % "jquery" % "1.11.3",
  "logger-mod" %% "logger-mod" % "1.0-SNAPSHOT",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
)
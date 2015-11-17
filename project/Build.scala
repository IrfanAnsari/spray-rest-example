import sbt.Keys._
import sbt._

object SprayBuild extends Build {

  val moduleName = "spray-rest-example"
  val specs2Version = "3.6.4"

  lazy val sprayRest = Project(id = moduleName, base = file("."))
    .configs(IntegrationTest)
    .settings(Defaults.itSettings: _*)
    .settings(name := moduleName,
      organization := "com.aal",
      version := "0.0.1-SNAPSHOT",
      scalaVersion := "2.11.7",
      scalacOptions ++= Seq(
        "-feature",
        "-language:implicitConversions",
        "-language:higherKinds",
        "-language:existentials",
        "-language:reflectiveCalls",
        "-language:postfixOps",
        "-Yrangepos",
        "-Yrepl-sync",
        "-Ylog-classpath"
      ),
      resolvers ++= Seq(),
      libraryDependencies ++= Seq(
        "org.clapper" %% "grizzled-slf4j" % "1.0.2",
        "ch.qos.logback" % "logback-classic" % "1.1.3",
        "com.typesafe" % "config" % "1.3.0" withSources(),
        "io.spray" %% "spray-can" % "1.3.3" withSources(),
        "io.spray" %% "spray-routing" % "1.3.3" withSources()
      ),
      libraryDependencies ++= Seq("org.mockito" % "mockito-all" % "1.10.19" withSources(),
        "org.specs2" %% "specs2-core" % specs2Version withSources(),
        "org.specs2" %% "specs2-mock" % specs2Version withSources() excludeAll ExclusionRule(organization = "org.mockito"),
        "org.specs2" %% "specs2-matcher-extra" % specs2Version withSources(),
        "org.specs2" %% "specs2-junit" % specs2Version withSources(),
        "io.spray" %% "spray-testkit" % "1.3.1" % "test"))
}
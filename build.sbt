ThisBuild / organization := "com.47deg"
ThisBuild / scalaVersion := "2.13.2"
ThisBuild / crossScalaVersions := Seq("2.11.12", "2.12.11", "2.13.2")

addCommandAlias("ci-test", "scalafmtCheckAll; scalafmtSbtCheck; mdoc; testCovered")
addCommandAlias("ci-docs", "github; mdoc; headerCreateAll; publishMicrosite")
addCommandAlias("ci-publish", "github; ci-release")

lazy val microsite = project
  .enablePlugins(MicrositesPlugin)
  .enablePlugins(ScalaUnidocPlugin)
  .dependsOn(allModules: _*)

lazy val documentation = project
  .settings(mdocOut := file("."))
  .enablePlugins(MdocPlugin)

lazy val `scalacheck-toolbox-datetime` = module
  .settings(description := "A library for helping use date and time libraries with ScalaCheck")
  .settings(libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.3")
  .settings(libraryDependencies += "joda-time" % "joda-time" % "2.10.6")
  .settings(libraryDependencies += "org.scala-lang.modules" %% "scala-collection-compat" % "2.2.0")

lazy val `scalacheck-toolbox-magic` = module
  .enablePlugins(BigListOfNaughtyStringsPlugin)
  .settings(description := "ScalaCheck Generators for magic values")
  .settings(libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.3")

lazy val `scalacheck-toolbox-combinators` = module
  .settings(description := "Useful generic combinators for ScalaCheck")
  .settings(libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.3")

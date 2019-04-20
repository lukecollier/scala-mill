import mill._, scalalib._, scalafmt._

object Version {
  val scala = "2.12.8"
  val cats = "1.6.0"
  val catsEffect = "1.2.0"
  val microTest = "0.6.7"
}

object app extends BaseModule {
  def moduleDeps = Seq(core)

  def ivyDeps = Agg(
  )

  object test extends Tests { 
    def ivyDeps = Agg(ivy"com.lihaoyi::utest::${Version.microTest}")
    def testFrameworks = Seq("utest.runner.Framework")
  }
}

object core extends BaseModule {
  object test extends Tests { 
    def ivyDeps = Agg(ivy"com.lihaoyi::utest::${Version.microTest}")
    def testFrameworks = Seq("utest.runner.Framework")
  }
}

trait BaseModule extends ScalaModule with ScalafmtModule {
  def scalaVersion = Version.scala

  def scalacOptions = Seq(
    "-deprecation",
    "-encoding", "utf-8",
    "-explaintypes",
    "-feature",
    "-language:existentials",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xcheckinit",
    "-Xfatal-warnings",
    "-Xfuture",
    "-Xlint:adapted-args",
    "-Xlint:by-name-right-associative",
    "-Xlint:constant",
    "-Xlint:delayedinit-select",
    "-Xlint:doc-detached",
    "-Xlint:inaccessible",
    "-Xlint:infer-any",
    "-Xlint:missing-interpolator",
    "-Xlint:nullary-override",
    "-Xlint:nullary-unit",
    "-Xlint:option-implicit",
    "-Xlint:package-object-classes",
    "-Xlint:poly-implicit-overload",
    "-Xlint:private-shadow",
    "-Xlint:stars-align",
    "-Xlint:type-parameter-shadow",
    "-Xlint:unsound-match",
    "-Yno-adapted-args",
    "-Ypartial-unification",
    "-Ywarn-dead-code",
    "-Ywarn-extra-implicit",
    "-Ywarn-inaccessible",
    "-Ywarn-infer-any",
    "-Ywarn-nullary-override",
    "-Ywarn-nullary-unit",
    "-Ywarn-numeric-widen",
    "-Ywarn-unused:implicits",
    "-Ywarn-unused:imports",
    "-Ywarn-unused:locals",
    "-Ywarn-unused:params",
    "-Ywarn-unused:patvars",
    "-Ywarn-unused:privates",
    "-Ywarn-value-discard"
  )

  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:${Version.cats}", 
    ivy"org.typelevel::cats-effect:${Version.catsEffect}",
  )

}

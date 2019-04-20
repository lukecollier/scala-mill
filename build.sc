import mill._, scalalib._, scalafmt._

object Version {
  val scala = "2.12.8"
  val cats = "1.6.0"
  val catsEffect = "1.2.0"
  val microTest = "0.6.7"
}

object app extends BaseModule {
  def moduleDeps = Seq(core)

  // def ivyDeps = Agg(
  // )

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


  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:${Version.cats}", 
    ivy"org.typelevel::cats-effect:${Version.catsEffect}",
  )

}

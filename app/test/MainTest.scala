package app

import utest._
import cats.effect._
import cats.syntax.all._

import Main._

object MainTest extends TestSuite{
  val tests = Tests{
    "one arg" - {
      run(List("Luke")) ==> IO.pure(ExitCode.Success)
    }
    "no args" - {
      run(List()) ==> IO.pure(ExitCode(2))
    }
  }
}

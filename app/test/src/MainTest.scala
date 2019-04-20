package app

import utest._
import cats.effect._
import cats.syntax.all._

import Main._

object MainTest extends TestSuite{
  val tests = Tests{
    "one arg" - {
      run(List("Luke")).unsafeRunSync ==> ExitCode.Success
    }
    "no args" - {
      run(List()).unsafeRunSync ==> ExitCode(2)
    }
  }
}

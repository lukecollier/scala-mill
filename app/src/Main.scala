package app

import cats.effect._
import cats.syntax.all._

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] =
    args.headOption match {
      case Some(name) =>
        IO(println(s"Hello, $name.")).as(ExitCode.Success)
      case None =>
        IO(System.err.println("Usage: App name")).as(ExitCode(2))
    }  
}


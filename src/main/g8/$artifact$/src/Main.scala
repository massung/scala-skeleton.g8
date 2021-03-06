package $group$.$artifact$

import cats._
import cats.effect._
import cats.implicits._

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger

object Main {
  val config = ConfigFactory.load()
  val logger = Logger(config.getString("logger.root"))

  /** Entry point. */
  def main(args: Array[String]): Unit = {
    val opts = new Opts(args)

    val io = IO {
      logger.info(opts.config.message)
    }

    // run the program
    io.unsafeRunSync
  }
}

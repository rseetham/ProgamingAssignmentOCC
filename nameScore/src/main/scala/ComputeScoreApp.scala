import ComputeScoreApp.args

import java.nio.file.{Files, Paths}
import scala.io.Source

object ComputeScoreApp extends App{
  override def main(args: Array[String]): Unit = {
    require(args.length == 1, "Needs a file containing names to run")
    require(Files.exists(Paths.get(args(0))), "Given input file path does not exist")
    val names = readFromFile(args(0))
    val score = scoreFirstNames(names)
    println(s"Score: $score")
  }

  def readFromFile(fileName: String): Seq[String] = {
    val bufferedSource = Source.fromFile(fileName)
    val namesString = bufferedSource.getLines.mkString
    bufferedSource.close()
    namesString.split(",").toSeq
  }

  def scoreFirstNames(names: Seq[String]): Int = {
    val scoreComputer = AlphabeticalScoring
    names.sorted.zipWithIndex.foldLeft(0){
      case (scoreSoFar, (name, index)) => scoreSoFar + scoreComputer.calculateScore(name, index + 1)
    }
  }
}

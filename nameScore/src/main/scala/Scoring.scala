trait Scoring {
  def calculateScore(name: String, position: Int): Int
}

object AlphabeticalScoring extends Scoring {
  private val letterWeights: Map[Char, Int] = ('A' to 'Z').zipWithIndex.map{ case (alphabet, index) =>
    alphabet -> (index + 1)
  }.toMap

  def calculateScore(name: String, position: Int): Int = {
    name.toUpperCase.toSeq.foldLeft(0){
      case (scoreSofar, letter) if letter.isLetter => letterWeights(letter) + scoreSofar
      case (scoreSofar, _) => scoreSofar
    } * position
  }
}



package occ.assignemnt

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AlphabeticalScoringTest extends AnyFunSpec with Matchers{

  describe("Alphabet scoring by weight of alphabet scoring") {
    val scoring = AlphabeticalScoring
    it("should return 0 for an empty string") {
      scoring.calculateScore("", 1) shouldBe 0
    }

    it("should return the right answer for a single character"){
      scoring.calculateScore("a", 1) shouldBe 1
      scoring.calculateScore("Z", 1) shouldBe 26
      scoring.calculateScore("e", 1) shouldBe 5
    }

    it("should return the right answer for first names") {
      scoring.calculateScore("LINDA", 1) shouldBe 40
      scoring.calculateScore("BARBARA", 1) shouldBe 43
    }

    it("should return the right answer regardless of case") {
      scoring.calculateScore("LINDA", 1) shouldBe 40
      scoring.calculateScore("linda", 1) shouldBe 40
      scoring.calculateScore("LInDa", 1) shouldBe 40
    }

    it("should ignore characters that are not letters while calculating the answer") {
      scoring.calculateScore("LIN DA", 1) shouldBe 40
      scoring.calculateScore("\"li$nda\"", 1) shouldBe 40
      scoring.calculateScore("LInD@a", 1) shouldBe 40
    }

    it("should take position into consideration") {
      scoring.calculateScore("LINDA", 5) shouldBe 40 * 5
      scoring.calculateScore("linda", 23) shouldBe 40 * 23
    }
  }

}

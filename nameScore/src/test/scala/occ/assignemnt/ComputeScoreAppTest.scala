package occ.assignemnt

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ComputeScoreAppTest extends AnyFunSpec with Matchers{
  it("returns the right score for a list of names") {
    val testStr = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\""
    val names = testStr.split(",")
    ComputeScoreApp.scoreFirstNames(names) shouldBe 3194
  }
}

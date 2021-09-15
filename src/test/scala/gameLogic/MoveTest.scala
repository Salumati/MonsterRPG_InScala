package gameLogic

import org.scalatest.wordspec.AnyWordSpec

class MoveTest extends AnyWordSpec{
  val element: Element = Element("Element")
  val move: Move = Move("moveName", 20, element)
  "A Move" must {
    "have a name" in {
      assert(move.name.isInstanceOf[String])
      assert(move.name.nonEmpty)
      assert(move.name=="moveName")
    }
    "have an attack strength" in{
      assert(move.attack.isInstanceOf[Int])
      assert(move.attack >= 0)
      // throw exception if attack is bellow 0,
      // healing should be handled with effect
    }
  }
  "A Move" should{
    "have a nice stringrepresentation" in{
      assert(move.toString.isInstanceOf[String])
      assert(move.toString == "moveName \nattack: 20")
    }
  }
}

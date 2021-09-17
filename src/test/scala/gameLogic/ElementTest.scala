package gameLogic

import org.scalatest.wordspec.AnyWordSpec

class ElementTest extends AnyWordSpec{
  val neutral: Element = Element("neutral")
  "A Element" should{
    "have a name" in{
      assert(neutral.name.isInstanceOf[String])
      assert(neutral.name == neutral.toString)
    }
  }
}

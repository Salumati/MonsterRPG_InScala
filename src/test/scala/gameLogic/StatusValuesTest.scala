package gameLogic

import org.scalatest.wordspec.AnyWordSpec

class StatusValuesTest extends AnyWordSpec{
  val statV: StatusValues = StatusValues(lifePoints = 100, attack = 30, defense = 40, initiative = 10)

  "a StatusValues" must{
    "have a LifePoints value" in{
      assert(statV.lifePoints.isInstanceOf[Int])
      assert(statV.lifePoints == 100)
    }
    "have an attack value" in{
      assert(statV.attack.isInstanceOf[Int])
      assert(statV.attack == 30)
    }
    "have a defense value" in{
      assert(statV.defense.isInstanceOf[Int])
      assert(statV.defense == 40)
    }
    "have an initiative value" in{
      assert(statV.initiative.isInstanceOf[Int])
      assert(statV.initiative == 10)
    }
  }
  "StatusValues" should{
    "have a nice Stringrepresentation" in{
      assert(statV.toString ==
        "LP: 100\n" +
        "attack: 30\n" +
        "defense: 40\n" +
        "initiative: 10\n")
    }
  }

}

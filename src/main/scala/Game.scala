import gameLogic.{Element, Move}

object Game {
  def main(args: Array[String]): Unit ={
    println("Welcome to Monster RPG!")

    // create elements:
    val neutral = Element("neutral")
    val water = Element("Water")
    val plant = Element("Plant")
    val fire = Element("Fire")

    // create moves
    val slash = Move("Slash", 60, element = neutral)
    val tackle = Move("Tackle",70, 90, element = neutral)
    val hardHit = Move("Hard Hit", 100, 50, neutral)
    val vineSlash = Move("Vine Slash", element = plant)
    val flowerBoom = Move("flower Boom", 80, 70, element = plant)
    val splash = Move("Splash", element = water)
    //val
    val ember = Move("Ember", element = fire)


    // create monsters

    // slime
    val slimeAttacks = List[Move](tackle, vineSlash, splash, ember)

    //val slime = gameLogic.Monster
    /*
    monsters:
      slime: neutral stats
      stegosaurus: high atk, high dfn, low mDfn
      turtle; high dfn, high mDfn, low init
      rabbit: high mAtk, high init, low dfn.
     */






  }
}

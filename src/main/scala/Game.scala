import gameLogic.{Battle, Element, Monster, Move, StatusValues}

import scala.io.StdIn.readLine

object Game {
  def main(args: Array[String]): Unit ={

    println("Welcome to Monster RPG!")

    // create elements:
    val neutral = Element("Neutral")
    val water = Element("Water", List("Plant"), List("Fire"))
    val plant = Element("Plant", List("Fire"), List("Water"))
    val fire = Element("Fire", List("Water"), List("Plant"))

    // neutral moves
    val tackle = Move("Tackle", element = neutral)
    val hardHit = Move("Hard Hit", attack = 100, neutral)

    // water moves
    val bubble = Move("Bubble", attack=40, water)
    val hydrogun = Move("Hydrogrun", attack=80, water)
    // mudsplash: lowers enemy init

    // plant moves
    val vineWhip = Move("Vine Whip", attack = 40, plant)
    val leafBlade = Move("Leaf Blade", attack = 80, plant)
    // include healing move (honeydew)
    // include def up move (barkshield)

    // fire moves
    val ember = Move("Ember", attack = 40, fire)
    val flameThrower = Move("Flame Thrower", attack = 80, element = fire)
    // include move that increases attack
    // include move that increases init

    // make monster move list
    val slimeMoves = List(tackle, bubble, vineWhip, ember)
    val rabbitMoves = List(tackle, hardHit, ember, flameThrower)
    val dinoMoves = List(tackle, hardHit, vineWhip, leafBlade)
    val snakeMoves = List(tackle, bubble, hydrogun, vineWhip)

    // make monster stats
    val slimeStats = StatusValues(lifePoints = 100, attack = 50, defense = 50, initiative = 50)
    val rabbitStats = StatusValues(lifePoints = 80, attack = 65, defense = 30, initiative = 75)
    val dinoStats = StatusValues(lifePoints = 100, attack = 50, defense = 70, initiative = 20)
    val snakeStats = StatusValues(lifePoints = 100, attack = 65, defense = 65, initiative = 50)

    // make monsters
    val slime = Monster("Slime", slimeStats, slimeMoves, neutral)
    val rabbit = Monster("Rabbit", rabbitStats, rabbitMoves, fire)
    val dino = Monster("Dino", dinoStats, dinoMoves, plant)
    val snake = Monster("Snake", snakeStats, snakeMoves, water)
    val monsters = List(slime, rabbit, snake, dino)
    println("created Monsters")


    // choose monster team:
    def showContent(seq:Seq[Any]): String = {
      var output = ""
      seq.zipWithIndex.foreach{case(move, count) => output += s"${count+1}) ${move.toString} \n"}
      output
    }
    println("choose your monster (type in number):")
    println(showContent(monsters))

    var input = readLine()
    // todo: validate value!
    val playerMonster = monsters(input.toInt - 1)
    println(s"you chose $playerMonster!")

    // chose enemy:
    println("choose your enemy (type in number):")
    println(showContent(monsters))
    input = readLine()
    val enemyMonster = monsters(input.toInt -1)

    // start battle
    println("battle start:")
    var battle = Battle(playerMonster, enemyMonster)
    do {
      println(battle.toString)
      println("what will you do?\n" + "a = attack\n" + "q = quit")
      input = readLine()
      println("input: " + input)
      if(input == "a"){
        println(s"what should ${battle.showPlayerMonster} do?")
        println(battle.showPlayerMonMoves)
        input = readLine()
        // todo: check if input is actually a number!
        var playerAction = battle.getPlayerAction(input.toInt)
        println(s"you chose $input, which is $playerAction")
        battle = battle.fight(playerAction)
        println(battle.playerMonster.showLP)
        println(battle.enemyMonster.showLP)
        println(battle.endGame)
      }
    }while(input != "q" && battle.continueBattle)
    println(battle.defeatMessage)

  }
}

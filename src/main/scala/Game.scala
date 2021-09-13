import gameLogic.{Battle, Monster, Move, StatusValues}

import scala.io.StdIn.readLine

object Game {
  def main(args: Array[String]): Unit ={
    println("Welcome to Monster RPG!")

    // create elements:

    // create moves
    val slash = Move("Slash", attack = 40)
    val tackle = Move("Tackle")
    val hardHit = Move("Hard Hit", attack = 100)

    val slimeMoves = List(slash, tackle)
    val rabbitMoves = List(tackle, hardHit)

    // create StatusValues
    val slimeStats = StatusValues(lifePoints = 100, attack = 50, defense = 50, initiative = 50)
    val rabbitStats = StatusValues(lifePoints = 80, attack = 65, defense = 30, initiative = 75)

    // create monsters
    println("creating Monsters")
    val slime = Monster("Slime", slimeStats, slimeMoves)
    val rabbit = Monster("Rabbit", rabbitStats, rabbitMoves)
    val allMonsters = List(slime, rabbit)
    val monsters = allMonsters.toArray
    println("created Monsters")


    // choose monster team:
    println("choose your monster (type in the appropriate number):\n" +
    s"1. $slime\n" +
    s"2. $rabbit")
    var input = readLine()
    // todo: validate value!
    val playerMonster = monsters(input.toInt - 1)
    println(s"you chose $playerMonster!")

    // chose enemy:
    println("choose your enemy (type in number):")
    println(
      s"1. $slime\n" +
      s"2. $rabbit")
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
        battle = battle.fight
        println(battle.playerMonster.showLP)
        println(battle.enemyMonster.showLP)
        println(battle.endGame)
      }
    }while(input != "q" && battle.continueBattle)
    println(battle.defeatMessage)

  }
}

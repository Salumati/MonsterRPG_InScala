package gameLogic

case class Battle(playerMonster:Monster, enemyMonster:Monster, round:Int = 1){
  // String methods:
  // general Strings
  override def toString: String = s"Your $playerMonster is fighting $enemyMonster! (round: $round)"

  // show monster:
  def showMonster(m:Monster): String = m.toString
  def showPlayerMonster: String = "Your " + showMonster(playerMonster)
  def showEnemyMonster: String = "enemy " + showMonster(enemyMonster)
  // show stats
  def showMonsterStat(m:Monster): String = s"${m.showStatus}"
  def showPlayerMonStat: String = showMonsterStat(playerMonster)
  def showEnemyMonStat: String = showMonsterStat(enemyMonster)
  // show LP
  def showMonsterLP(m:Monster): String = s"${m.showLP}"
  def showPlayerMonLP: String = showMonsterLP(playerMonster)
  def showEnemyMonLP: String = showMonsterLP(enemyMonster)
  // show Moves:
  def showMonsterMoves(m:Monster):String = m.showMoves
  def showPlayerMonMoves: String = showMonsterMoves(playerMonster)
  def showEnemyMonMoves: String = showMonsterMoves(enemyMonster)
  // defeat Message
  def defeatMessage:String = s"$getDefeatedMon has been defeated"

  // functionality
  def battleOrder:List[Monster] = List(playerMonster, enemyMonster).sortWith(_.stats.initiative > _.stats.initiative)
  def monsterIsDefeated(monster:Monster): Boolean = monster.isDefeated
  def monsterAttack(attackingMonster:Monster, defendingMonster:Monster): Monster = {
    if(!attackingMonster.isDefeated) defendingMonster.defend(attackingMonster.attack(attackingMonster.moveSet.head))
    else defendingMonster
    // this should idealy include a text, but I am not sure where to include it.
  }
  // note: once special effects get added to Moves, the attacking Monster might change after attack as well

  def endGame: Boolean = playerMonster.isDefeated || enemyMonster.isDefeated
  def continueBattle: Boolean = !endGame
  def getDefeatedMon: List[Monster] = List(enemyMonster, playerMonster).filter(_.isDefeated)

  def fight: Battle = {
    val newEnMon = monsterAttack(playerMonster, enemyMonster)
    val newPlMon = monsterAttack(newEnMon, playerMonster)
    /*
    val m1 = monsterAttack(attackingMonster = battleOrder.head, defendingMonster = battleOrder.last)
    val m2 = monsterAttack(attackingMonster = m1, defendingMonster = battleOrder.head)
     */
    this.copy(playerMonster = newPlMon, enemyMonster = newEnMon, round = round + 1)
    // todo: include proper battle order, based on int value
  }
}
/*
  adtitional implimentation goals:
  * allow player to change monster during battle
  * allow double battles
  *
 */
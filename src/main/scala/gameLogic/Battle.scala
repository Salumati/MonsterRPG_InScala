package gameLogic

case class Battle(playerMonster:Monster, enemyMonster:Monster, round:Int = 1){
  // String methods:
  // general Strings
  override def toString: String = s"Your $playerMonster is fighting $showEnemyMonster! (round: $round)"

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
  def defeatMessage:String = s"${getDefeatedMon.head.toString} has been defeated"

  // functionality
  def battleOrder:List[Monster] = List(playerMonster, enemyMonster).sortWith(_.stats.initiative > _.stats.initiative)
  // todo: check if battleOrder is even necessary
  def doesPlayerGoFirst: Boolean = playerMonster.stats.initiative >= enemyMonster.stats.initiative
  def monsterIsDefeated(monster:Monster): Boolean = monster.isDefeated

  def getPlayerAction(move:Int):Move = playerMonster.chooseMove(move)
  def monsterAttack(attackingMonster:Monster, defendingMonster:Monster, usedMove:Move): Monster = {
    // calculate attack, return the monster that was attacked.
    if(!attackingMonster.isDefeated) defendingMonster.defend((attackingMonster.attack(usedMove) * defendingMonster.getDefenseBonus(usedMove)).toInt)
    else defendingMonster
    // this should idealy include a text, but I am not sure where to include it.
    // todo: this ins't very readable, maybe we can rephrase this somehow
  }
  // note: once special effects get added to Moves, the attacking Monster might change after attack as well

  def endGame: Boolean = playerMonster.isDefeated || enemyMonster.isDefeated
  def continueBattle: Boolean = !endGame
  def getDefeatedMon: List[Monster] = List(enemyMonster, playerMonster).filter(_.isDefeated)

  def nextRound: Battle = this.copy(round = round+1)

  def fight(playerMove:Move): Battle = {
    var newPlMon = playerMonster
    var newEnMon = enemyMonster
    if(doesPlayerGoFirst){
      // player goes first
      newEnMon  = monsterAttack(playerMonster, enemyMonster, playerMove)
      newPlMon = monsterAttack(newEnMon, playerMonster, enemyMonster.chooseMove(1))
    } else {
      // enemy goes first
      newPlMon = monsterAttack(enemyMonster, playerMonster, enemyMonster.chooseMove(1))
      newEnMon = monsterAttack(newPlMon, enemyMonster, playerMove)
    }
    this.copy(playerMonster = newPlMon, enemyMonster = newEnMon, round = round + 1)
  }
  /*
  Battle order:
  1st Both monsters choose a move
  2nd determine who goes first (usually the one with the higher initiative, but attack effects could changes this
  -> it might be usefull to have a higher order class handle the different
  3rd calculate damage
  4th start next round
   */
}
/*
  adtitional implimentation goals:
  * allow player to change monster during battle
  * allow double battles
  *
 */
package gameLogic

case class Battle(monster1:Monster, monster2:Monster, round:Int = 1){
  // String methods:
  override def toString: String = s"$monster1 is fighting $monster2!"
  def showMonster(m:Monster):String = m.toString
  def showMonsterMoves(m:Monster):String = m.showMoves
  def defeatMessage:String = s"$getDefeatedMon has been defeated"

  // functionality
  def battleOrder:List[Monster] = List(monster1, monster2).sortWith(_.stats.initiative > _.stats.initiative)
  def monsterIsDefeated(monster:Monster): Boolean = monster.defeated
  def monsterAttack(attackingMonster:Monster, defendingMonster:Monster): Monster = {
    if(!attackingMonster.defeated) defendingMonster.defend(attackingMonster.attack(attackingMonster.moveSet.head))
    else defendingMonster
  }
  // note: once special effects get added to Moves, the attacking Monster might change after attack as well

  def endGame: Boolean = monster1.defeated || monster2.defeated
  def getDefeatedMon: List[Monster] = List(monster2, monster1).filter(_.defeated)

  def fight: Battle = {
    val m1 = monsterAttack(attackingMonster = battleOrder.head, defendingMonster = battleOrder.last)
    val m2 = monsterAttack(attackingMonster = m1, defendingMonster = battleOrder.head)
    this.copy(monster1 = m1, monster2 = m2, round = round + 1)
  }
}
/*
  adtitional implimentation goals:
  * allow player to change monster during battle
  * allow double battles
  *
 */
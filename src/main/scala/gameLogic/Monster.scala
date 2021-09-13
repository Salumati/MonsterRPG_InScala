package gameLogic

case class Monster(name:String, stats:StatusValues, moveSet:Array[Move], damage:Int = 0){
  // Strings
  override def toString: String = s"$name"
  def showLP: String = s"$name: $calcDamage LP"
  def showStatus: String = s"$name Status:\n" + "$stats"
  def showMoves: String = {
    var output = ""
    moveSet.zipWithIndex.foreach{case(move, count) => output += s"${count+1}) ${move.name} \n"}
    output
  }

  // calculations
  def calcDamage: Int = stats.lifePoints - damage
  def isDefeated: Boolean = calcDamage <= 0

  // functionality
  def chooseMove(pos:Int): Move = moveSet(pos-1)
  def attack(move:Move):Int = stats.attack + move.attack
  def defend(dmg:Int):Monster = this.copy(damage = damage + (stats.defense - dmg).abs)
}
/*
  adtitional implimentation goals:
  * add ability
  * add differentiation between magic moves and non magic moves
 */
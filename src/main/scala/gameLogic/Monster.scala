package gameLogic

case class Monster(name:String, stats:StatusValues, moveSet:List[Move], damage:Int = 0){
  // Strings
  override def toString: String = s"$name, $showLP"
  def showStatus: String = s"$name Status:\n" + "$stats"
  def showMoves: String = moveSet.toString

  // calculations
  def calcDamage: Int = stats.lifePoints - damage
  def showLP: String = s"LP: $calcDamage"
  def defeated: Boolean = calcDamage <= 0

  // behavior
  def attack(move:Move):Int = stats.attack + move.attack
  def defend(dmg:Int):Monster = this.copy(damage = (stats.defense - dmg).abs)
}
/*
  adtitional implimentation goals:
  * add ability
  * add differentiation between magic moves and non magic moves
 */
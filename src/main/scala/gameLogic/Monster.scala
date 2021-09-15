package gameLogic

case class Monster(name:String, stats:StatusValues, moveSet:List[Move], element: Element, damage:Int = 0){
  // Strings
  override def toString: String = name
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
  def isWeakTo(el:Element):Boolean = element.isWeakTo(el)
  def isStrongTo(el: Element):Boolean = element.isStrongTo(el)
  def getDefenseBonus(move: Move): Double = {
    // will change the amount of damage taken by enemy
    val el = move.element
    if(isWeakTo(el)) 2.0
    else if(isStrongTo(el)) 0.5
    else 1.0
  }

  // functionality
  def chooseMove(pos:Int): Move = moveSet(pos-1)
  def isSTABMove(move:Move):Boolean = move.element == this.element
  def getSTABBonus(move:Move):Double = {
    if(isSTABMove(move)) 1.5
    else 1}
  def attack(move:Move):Int = (stats.attack + move.attack * getSTABBonus(move)).toInt  // note, I do not know how this will round up/down
  def defend(dmg:Int):Monster = this.copy(damage = damage + (stats.defense - dmg).abs)
}
/*
  adtitional implimentation goals:
  * add ability
  * add differentiation between magic moves and non magic moves
 */
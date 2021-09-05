package gameLogic

case class StatusValues(lifePoints:Int, attack: Int, defense: Int, initiative: Int){
  // how can I make sure that none of the Values are negative?
  override def toString:String = {
    s"LP: $lifePoints\n"+
    s"attack: $attack\n" +
    s"defense: $defense\n" +
    s"initiative: $initiative\n"
  }
}
/*
  adtitional implimentation goals:
  * add magic defense and magic attack
 */
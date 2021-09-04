package gameLogic

// create moves
case class Move(name:String, attack:Int=50){
  override def toString:String =
      s"$name \n" +
      s"attack: $attack"
}
/*
  adtitional implimentation goals:
  * add an effect (e.g. healing, afflicting status ailments, changing stats)
  * add priority
  * make a differentiation between  touching moves and non touching moves
  * add element
  * add accuracy
 */
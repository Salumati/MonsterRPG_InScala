package gameLogic

// create moves
case class Move(name:String, attack:Int=50, element:Element){
  // todo: include neutral as standard element, not sure where to properly define it
  override def toString:String = name
  def showMoveStat: String = {
      s"$name \n" +
      s"attack: $attack"
  }
  def isWeakTowards(el: Element): Boolean = element.isWeakTo(el)
  def isStrongTowards(el: Element): Boolean = element.isStrongTo(el)

  def getDamageAdaption(el:Element): Double = {
    // todo: find prettier way to do this
    var adaption = 1
    if(this.isWeakTowards(el)) adaption = adaption * 1/2
    if(this.isStrongTowards(el)) adaption = adaption * 2
    adaption
  }

}
/*
  adtitional implimentation goals:
  * add an effect (e.g. healing, afflicting status ailments, changing stats)
  * add priority
  * make a differentiation between  touching moves and non touching moves
  * add element
  * add accuracy
 */
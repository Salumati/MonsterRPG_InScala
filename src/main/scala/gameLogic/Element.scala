package gameLogic

case class Element(name: String, weaknesses:List[String]=Nil, strength:List[String]=Nil){
  // todo: doing this with lists of strings is probably not good, need to find better way
  override def toString: String = name
  def showWeaknesses: String = weaknesses.toString
  def showStrengths: String = strength.toString

  def isWeakTo(element: Element):Boolean = weaknesses.contains(element.toString)
  def isStrongTo(element:Element):Boolean = strength.contains(element.toString)
}
//based on a scala book example for enumerations, might be more fitting
/*
sealed trait Element
case object Neutral extends Element
case object Water extends Element
case object Fire extends Element
case object Plant extends Element
*/


// maybe save type weaknesses as a match expression
// this should also include
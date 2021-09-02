package gameLogic

case class Element(element: String)

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
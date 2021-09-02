package gameLogic

object GameMath {

  import scala.util.Random

  // set up for random number generator:
  val rand = new Random()

  // move/attack related:
  def calcHit(ack: Int): Boolean = rand.nextInt(100) <= ack // does a move hit?

  def calcAttack(atkMonster: Int, atkMove: Int): Int = {
    atkMonster + atkMove
  }

  def calcDamage(dfn: Int, atk: Int): Int = {
    (atk - dfn).max(0)
  }


}

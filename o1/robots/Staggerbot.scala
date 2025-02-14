package o1.robots

import o1.CompassDir
import scala.util.Random

class Staggerbot(name: String, body: RobotBody, randomSeed: Int) extends RobotBrain(name, body):

  private val random = Random(randomSeed)
  private val allDirections = Vector(CompassDir.North, CompassDir.East, CompassDir.South, CompassDir.West) // indexed collection of compass directions

  private def randomDirection(): CompassDir =
    allDirections(random.nextInt(allDirections.size))

  def moveBody(): Unit =
    val moveDir = randomDirection()
    if (body.moveTowards(moveDir)) then  // True if movement succeeded without collisions.
      body.spinTowards(randomDirection()) // Select a new random direction to face if no collision.
  // If there's a collision, the bot remains facing the collision direction, so no further action needed.

end Staggerbot

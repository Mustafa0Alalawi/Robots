package o1.robots

import o1.*

class Lovebot(name: String, body: RobotBody, val beloved: RobotBody) extends RobotBrain(name, body):



  def moveBody(): Unit =
  if body.isIntact && !isAdjacentToBeloved then
    val (dx, dy) = (beloved.location.x - body.location.x, beloved.location.y - body.location.y)
    val moveDirection =
      if Math.abs(dx) > Math.abs(dy) then
        // Prioritize horizontal movement
        if dx > 0 then CompassDir.East else CompassDir.West
      else if Math.abs(dy) > Math.abs(dx) then
        // Prioritize vertical movement
        if dy > 0 then CompassDir.South else CompassDir.North
      else
        // If dx and dy are equal, choose either direction. For this example, we prioritize horizontal movement.
        if dx > 0 then CompassDir.East else CompassDir.West
    body.moveTowards(moveDirection)


  private def isAdjacentToBeloved: Boolean =
    val (dx, dy) = (Math.abs(beloved.location.x - body.location.x), Math.abs(beloved.location.y - body.location.y))
    (dx == 1 && dy == 0) || (dx == 0 && dy == 1)

end Lovebot

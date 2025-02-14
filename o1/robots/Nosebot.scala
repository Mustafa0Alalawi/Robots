package o1.robots

import o1._

class Nosebot(name: String, body: RobotBody) extends RobotBrain(name, body):

  // Tries to move the robot one step forward. If it can't, turns the robot 90 degrees clockwise.
  def attemptMove(): Boolean =
    if mayAdvance(facing) then
      advanceCarefully()
      true
    else
      body.spinClockwise()
      false

  // Checks if the robot can advance in the given direction.
  // Nosebot considers any non-empty square as an obstacle.
  override def mayAdvance(direction: CompassDir): Boolean =
    body.neighboringSquare(direction).isEmpty

  // Tries to move the robot, and stops after 4 unsuccessful attempts (a full rotation).
  def moveBody(): Unit =
    var attempts = 0
    while attempts < 4 && !attemptMove() do
      attempts += 1

end Nosebot

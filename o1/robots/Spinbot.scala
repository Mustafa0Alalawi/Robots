package o1.robots

import o1._

class Spinbot(name: String, body: RobotBody) extends RobotBrain(name, body):

  /** Moves the robot. A spinbot simply spins 90 degrees clockwise as its move. */
  def moveBody() =
    body.spinClockwise() // Instructs the robot body to spin clockwise

end Spinbot

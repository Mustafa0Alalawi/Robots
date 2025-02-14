package o1.robots

import o1.grid._

class RobotWorld(floorWidth: Int, floorHeight: Int) extends Grid[Square](floorWidth + 2, floorHeight + 2):
  
  private var robots = Vector[RobotBody]()
  private var turn = 0

  def initialElements =
    for
      y <- 0 until this.height
      x <- 0 until this.width
    yield
      initialSquare(x, y)

  private def initialSquare(x: Int, y: Int): Square =
    if x == 0 || y == 0 || x == this.width - 1 || y == this.height - 1 then
      Wall
    else
      Floor()

  def addRobot(initialLocation: GridPos, initialFacing: CompassDir) =
    val newRobot = RobotBody(this, initialLocation, initialFacing)
    this.robots = this.robots :+ newRobot
    val initialSquare = this.elementAt(initialLocation)
    initialSquare.addRobot(newRobot)
    newRobot


  def addWall(location: GridPos): Unit =
    update(location, Wall)

  def numberOfRobots: Int = robots.size

  def robotList: Vector[RobotBody] = robots

  def robotWithNextTurn: Option[RobotBody] =
    if this.robots.isEmpty then
      None
    else
      val nextRobot = Some(this.robots(this.turn % this.robots.size))
      nextRobot

  def advanceTurn() =
    robotWithNextTurn match
      case Some(robot) =>
        robot.takeTurn()
        turn = (this.turn + 1) % numberOfRobots
      case None => // DoNothing

  def advanceFullRound() =
    numberOfRobots
    if numberOfRobots > 0 then
      for index <- 0 until numberOfRobots do
        advanceTurn()

end RobotWorld

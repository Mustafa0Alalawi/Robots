package o1.robots

import o1._

class Slaybot(name: String, body: RobotBody) extends RobotBrain(name, body):


  def moveBody(): Unit =
    val directions = List(CompassDir.North, CompassDir.East, CompassDir.South, CompassDir.West)
    var scan = true
    var i = 0
    while scan && i<=3 do
      if findVictim(directions(i)) then
        this.body.spinTowards(directions(i))
        scan = false
      else
        i = i+1

    if !scan then
      approachAndRam(directions(i))




  private def findVictim(dir: CompassDir): Boolean =

    var orignal = this.location
    while this.world.apply(orignal.neighbor(dir)).isEmpty do
      orignal = orignal.neighbor(dir)

    if !this.world.apply(orignal.neighbor(dir)).isUnpassable then
      if this.world.apply(orignal.neighbor(dir)).robot.isDefined && this.world.apply(orignal.neighbor(dir)).robot.get.isIntact then
        true
      else
        false
    else
      false




  private def approachAndRam(direction: CompassDir): Unit =

    while this.world.apply(this.location.neighbor(direction)).isEmpty do
     this.body.moveTowards(direction)

    this.world.apply(this.location.neighbor(direction)).robot.get.destroy()



end Slaybot

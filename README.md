# 🤖 Robotics Simulator

A modular, Scala-based robot simulator in which autonomous, simple-minded robots navigate a grid-based world. This project showcases object-oriented design, AI behaviors, and simulation logic through an extendable and visual environment.


---

## Project Overview

**Robotics** is a simulation game where various robot types move through a world made of walls and floor tiles. Each robot has its own behavior ("brain") and a physical body. The simulation takes place on a grid, and players can observe how different robots behave over time.


---

## Components

| Component         | Description                                                                 
|------------------|-----------------------------------------------------------------------------
| `GridPos`        | Represents a position on the grid.                                          
| `Grid`           | Abstract base for grid systems.                                             
| `CompassDir`     | Enum for directions: north, east, south, west.                              
| `RobotBody`      | Physical body of a robot (location, state, direction).                      
| `RobotBrain`     | AI interface for robot behaviors.                                           
| `Spinbot`, `Nosebot`, etc. | Subclasses defining unique behaviors.                            
| `Square`         | Base trait for world tiles.                                                 
| `Floor`          | A walkable tile in the world.                                               
| `Wall`           | A shared object representing impassable wall tiles.                         
| `RobotWorld`     | The simulation environment containing robots and tiles.                     

---

## Screenshots

<img width="858" alt="Screenshot 2025-05-13 at 19 16 32" src="https://github.com/user-attachments/assets/d2861981-d5a2-44d0-89df-81fa56843953" />
<img width="732" alt="Screenshot 2025-05-13 at 19 16 43" src="https://github.com/user-attachments/assets/1aeac8e2-0890-4942-bd27-646991ffce85" />
<img width="863" alt="Screenshot 2025-05-13 at 19 17 01" src="https://github.com/user-attachments/assets/6c316341-7433-40cc-90be-3d89cb2c41ac" />
<img width="1152" alt="Screenshot 2025-05-13 at 19 17 27" src="https://github.com/user-attachments/assets/122bd24b-ed64-413e-85df-0d012bfc74f2" />

---

## Getting Started

### Requirements

- [Scala](https://www.scala-lang.org/)
- [SBT (Scala Build Tool)](https://www.scala-sbt.org/)

### Run the Simulation

```bash
git clone https://github.com/Mustafa0Alalawi/Robots.git
cd Robots
sbt run
```

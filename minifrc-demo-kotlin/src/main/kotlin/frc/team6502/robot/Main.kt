package frc.team6502.robot

import edu.wpi.first.wpilibj.RobotBase

/**
 * Entry point for the robot project.
 * Do not touch or you will break things.
 */
class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RobotBase.startRobot(::Robot)
        }
    }
}

package frc.team6502.robot

import edu.wpi.first.hal.FRCNetComm
import edu.wpi.first.hal.HAL
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj2.command.CommandScheduler

/**
 * Main robot class providing hooks for various robot states.
 * Since we are using commands, there shouldn't be too much functionality here other than calling the scheduler.
 */
class Robot : TimedRobot() {

    /**
     * Runs on startup
     */
    override fun robotInit() {
        // report the language as kotlin. not required, but it tells FIRST we are using it
        HAL.report(FRCNetComm.tResourceType.kResourceType_Language, FRCNetComm.tInstances.kLanguage_Kotlin)

        // reference RobotContainer singleton by name to trigger its constructor
        // this trickles down to all other subsystem constructors, setting everything up
        // without this initialization, the robot will do absolutely nothing
        RobotContainer
    }

    /**
     * Runs periodically always
     */
    override fun robotPeriodic() {
        // process command state continuously. make sure this is always called periodically
        CommandScheduler.getInstance().run()
    }

    /**
     * Runs upon disable
     */
    override fun disabledInit() {
    }

    /**
     * Runs periodically when disabled
     */
    override fun disabledPeriodic() {
    }

    /**
     * Runs upon entering teleop
     */
    override fun teleopInit() {
    }

    /**
     * Runs periodically when enabled in teleop
     */
    override fun teleopPeriodic() {
    }

    /**
     * Runs upon entering auto
     */
    override fun autonomousInit() {
    }

    /**
     * Runs periodically when enabled in auto
     */
    override fun autonomousPeriodic() {
    }
}

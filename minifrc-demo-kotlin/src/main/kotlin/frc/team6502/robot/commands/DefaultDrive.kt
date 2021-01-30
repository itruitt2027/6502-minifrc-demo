package frc.team6502.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.team6502.robot.RobotContainer
import frc.team6502.robot.subsystems.Drivetrain

/**
 * A generic drive command which controls the drivetrain based on joystick inputs.
 */
class DefaultDrive : CommandBase() {

    init {
        // add drivetrain as a requirement so nothing else can use it
        addRequirements(Drivetrain)
    }

    /**
     * Runs continuously during command execution
     */
    override fun execute() {
        // feed stick values into Drivetrain.arcadeDrive
        Drivetrain.arcadeDrive(RobotContainer.throttleSupplier.asDouble, RobotContainer.turnSupplier.asDouble)
    }

    /**
     * If this command ends, make sure the drivetrain is stopped.
     * Technically not needed, but good practice/safety to have this anyway
     */
    override fun end(interrupted: Boolean) {
        Drivetrain.arcadeDrive(0.0,0.0)
    }

    /**
     * This command should always run, so it will never be finished.
     */
    override fun isFinished() = false
}

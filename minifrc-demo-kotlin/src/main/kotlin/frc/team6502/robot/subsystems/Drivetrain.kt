package frc.team6502.robot.subsystems

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team6502.robot.LEFT_SPARK_ID
import frc.team6502.robot.RIGHT_SPARK_ID
import frc.team6502.robot.commands.DefaultDrive

/**
 * Subsystem which is responsible for robot movement.
 */
object Drivetrain : SubsystemBase() {

    // set up the left and right motor controllers for the drivetrain. assumed to be brushless motors (neos), change MotorType if not
    private val leftSpark = CANSparkMax(LEFT_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply {
        idleMode = CANSparkMax.IdleMode.kBrake
    }

    private val rightSpark = CANSparkMax(RIGHT_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply {
        idleMode = CANSparkMax.IdleMode.kBrake
    }

    /**
     * A class that handles commanding motors based on joystick input.
     * Replace this with DifferentialDriveKinematics for similar functionality when working with velocity instead of %.
     */
    private val differentialDrive = DifferentialDrive(leftSpark, rightSpark)

    init {
        // make a new DefaultDrive instance, setting it as the drivetrain's default command so it will run by default.
        defaultCommand = DefaultDrive()
    }

    /**
     * Set the motors based on given throttle and turn rate values.
     * @param throttle scalar from -1 to 1, reflecting % linear speed
     * @param turn scalar from -1 to 1, reflecting % turn speed
     */
    fun arcadeDrive(throttle: Double, turn: Double) {
        differentialDrive.arcadeDrive(throttle, turn)
    }
}

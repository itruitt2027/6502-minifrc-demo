package frc.team6502.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj2.command.PrintCommand
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import frc.team6502.robot.subsystems.Drivetrain
import java.util.function.DoubleSupplier

/**
 * Singleton that holds references to "global hardware" on the robot or things that don't belong to a specific subsystem
 */
object RobotContainer {

    private val joystick = Joystick(JOYSTICK_PORT)

    val throttleSupplier = DoubleSupplier {
        // we invert the throttle since up on the stick maps to negative values, but we want up=positive=forwards
        // this inversion can be removed if you'd like to invert your robot's direction of motion
        -joystick.getRawAxis(1)
    }

    val turnSupplier = DoubleSupplier {
        joystick.getRawAxis(2)
    }

    // NOTE: button & axis mappings are visible in a driver station tab.
    // you can also find them on the internet, but they can be inconsistent

    init {
        // make sure all subsystem singletons initialize on boot by referencing them by name:
        Drivetrain

        // demonstrate how to use buttons with commands (button 1 is A)
        JoystickButton(joystick, 1).whenPressed(PrintCommand("Pressed A button!"))
    }
}

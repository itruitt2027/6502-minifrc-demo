// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6502.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.team6502.robot.commands.DefaultDrive;
import frc.team6502.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final Joystick m_joystick = new Joystick(Constants.JOYSTICK_PORT);

  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();

  private final DoubleSupplier m_throttleSupplier = () -> {
    // we invert the throttle since up on the stick maps to negative values, but we want up=positive=forwards
    // this inversion can be removed if you'd like to invert your robot's direction of motion
    return -m_joystick.getRawAxis(1);
  };

  private final DoubleSupplier m_turnSupplier = () -> {
    return m_joystick.getRawAxis(2);
  };


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // make a new DefaultDrive instance, setting it as the drivetrain's default command so it will run by default, injecting
    // RobotContainer's dependencies so DefaultDrive can access them
    m_drivetrain.setDefaultCommand(new DefaultDrive(m_drivetrain, m_throttleSupplier, m_turnSupplier));

    // demonstrate how to use buttons with commands (button 1 is A)
    JoystickButton aButton = new JoystickButton(m_joystick, 1);
    aButton.whenPressed(new PrintCommand("Pressed A button!"));
  }

}

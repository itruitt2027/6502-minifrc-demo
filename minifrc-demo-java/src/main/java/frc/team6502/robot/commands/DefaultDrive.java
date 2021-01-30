// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6502.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team6502.robot.subsystems.Drivetrain;

/**
 * A generic drive command which controls the drivetrain based on joystick inputs.
 */
public class DefaultDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  // reference to the drivetrain subsystem obtained via dependency injection
  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_throttleSupplier;
  private final DoubleSupplier m_turnSupplier;

  /**
   * Creates a new DefaultDrive command.
   *
   * @param drivetrain The drivetrain subsystem used by this command.
   * @param throttle The supplier for the throttle axis
   * @param turn The supplier for the turn axis
   */
  public DefaultDrive(Drivetrain drivetrain, DoubleSupplier throttle, DoubleSupplier turn) {
    m_drivetrain = drivetrain;
    m_throttleSupplier = throttle;
    m_turnSupplier = turn;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  /**
   * Runs continuously during command execution
   */
  @Override
  public void execute() {
    // feed stick values into Drivetrain.arcadeDrive
    m_drivetrain.arcadeDrive(m_throttleSupplier.getAsDouble(), m_turnSupplier.getAsDouble());
  }

  /**
   * If this command ends, make sure the drivetrain is stopped.
   * Technically not needed, but good practice/safety to have this anyway
   */
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

  /**
   * This command should always run, so it will never be finished.
   */
  @Override
  public boolean isFinished() {
    return false;
  }
}

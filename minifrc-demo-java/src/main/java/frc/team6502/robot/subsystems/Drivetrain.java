// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6502.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team6502.robot.Constants;

/**
 * Subsystem which is responsible for robot movement.
 */
public class Drivetrain extends SubsystemBase {

  private final CANSparkMax leftSpark;
  private final CANSparkMax rightSpark;

  /**
   * A class that handles commanding motors based on joystick input.
   * Replace this with DifferentialDriveKinematics for similar functionality when working with velocity instead of %.
  */
  private final DifferentialDrive differentialDrive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    // set up the left and right motor controllers for the drivetrain. assumed to be brushless motors (neos), change MotorType if not
    leftSpark = new CANSparkMax(Constants.LEFT_SPARK_ID, MotorType.kBrushless);
    rightSpark = new CANSparkMax(Constants.RIGHT_SPARK_ID, MotorType.kBrushless);

    leftSpark.setIdleMode(IdleMode.kBrake);
    rightSpark.setIdleMode(IdleMode.kBrake);

    differentialDrive = new DifferentialDrive(leftSpark, rightSpark);
  }

  /**
   * Set the motors based on given throttle and turn rate values.
   * @param throttle scalar from -1 to 1, reflecting % linear speed
   * @param turn scalar from -1 to 1, reflecting % turn speed
   */
  public void arcadeDrive(double throttle, double turn) {
    differentialDrive.arcadeDrive(throttle, turn);
  }
  
}

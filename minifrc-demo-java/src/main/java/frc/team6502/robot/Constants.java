// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6502.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /**
     * The port which the joystick is connected to. Configurable/visible in the driver station.
     */
    public static final int JOYSTICK_PORT = 0;

    /**
     * The CAN id of the Drivetrain's left Spark MAX.
     * @see frc.team6502.robot.subsystems.Drivetrain
     */
    public static final int LEFT_SPARK_ID = 1;

    /**
     * The CAN id of the Drivetrain's right Spark MAX.
     * @see frc.team6502.robot.subsystems.Drivetrain
     */
    public static final int RIGHT_SPARK_ID = 2;
}

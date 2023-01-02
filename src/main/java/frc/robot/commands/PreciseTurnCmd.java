// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsys;
import static frc.robot.Constants.SingleInstance.*;
import static frc.robot.Algorithm.*;
import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;

public class PreciseTurnCmd extends CommandBase {
  private DriveBaseSubsys m_driveBase;
  private double initAngle = 0;
  /** Creates a new PreciseTurnCmd. */
  public PreciseTurnCmd(DriveBaseSubsys __subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveBase = __subsystem;
    addRequirements(m_driveBase);
    addRequirements(GYRO);
    addRequirements(PIDCONTROLLER);
    PIDCONTROLLER.setSetpoint(initAngle);
    PIDCONTROLLER.enableContinuousInput(-180, 180);
    PIDCONTROLLER.setIntegratorRange(-10, 1);
    PIDCONTROLLER.setTolerance();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initAngle = GYRO.getYaw();
    GYRO.reset();
    PIDCONTROLLER.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (PIDCONTROLLER.isAtSetpoint()) {
      m_driveBase.drive(0.0, 0.0);
      return;
    }
    double joystickAngle = 90.0 - Math.toDegrees(Math.atan2(JOYSTICK.getRawAxis(XAXISRIGHT1), -JOYSTICK.getRawAxis(YAXISRIGHT1)));
    PIDCONTROLLER.setSetpoint(simplifyAngle(initAngle + joystickAngle));
    double speed = PIDCONTROLLER.calculate(GYRO.getYaw()); // get speed
    speed += Math.signum(speed) * 0.1; // lower bound
    speed = clamp(speed, -0.6, 0.6); // upper bound
    m_driveBase.drive(-speed, speed); // actual driving mechanism
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

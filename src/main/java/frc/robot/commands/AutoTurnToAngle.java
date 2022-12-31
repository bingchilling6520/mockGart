// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsys;
import static frc.robot.Constants.SingleInstance.*;
import static frc.robot.Algorithm.*;

public class AutoTurnToAngle extends CommandBase {
  DriveBaseSubsys m_driveBase;
  double targetAngle;
  /** Creates a new AutoTurnToAngle. */
  public AutoTurnToAngle(DriveBaseSubsys __driveBase, double __angle) {
    m_driveBase = __driveBase;
    addRequirements(m_driveBase);
    addRequirements(GYRO);
    addRequirements(PIDCONTROLLER);
    targetAngle = __angle;

    
    PIDCONTROLLER.setSetpoint(targetAngle);
    PIDCONTROLLER.enableContinuousInput(-180, 180);
    PIDCONTROLLER.setIntegratorRange(-10, 1);
    PIDCONTROLLER.setTolerance();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    GYRO.reset();
    PIDCONTROLLER.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = PIDCONTROLLER.calculate(GYRO.getYaw()); // get speed
    speed += Math.signum(speed) * 0.1; // lower bound
    speed = clamp(speed, -0.6, 0.6); // upper bound
    m_driveBase.drive(-speed, speed); // actual driving mechanism
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveBase.drive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return PIDCONTROLLER.isAtSetpoint();
  }
}

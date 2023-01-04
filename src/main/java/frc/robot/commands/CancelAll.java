// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import static frc.robot.Constants.SingleInstance.*;
import static java.lang.Exception.*;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class CancelAll extends CommandBase {
  /** Creates a new CancelAll. */
  public CancelAll() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveBaseSubsystem.drive(0.0, 0.0);
    m_frontTrapDoorSubsystem.rotate(0.0);
    m_backTrapDoorSubsystem.rotate(0.0);
    m_pulleySubsystem.pull(0.0, 0.0);
    m_intakeSubsystem.rotate(0.0);
    throw new NullPointerException("stop");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

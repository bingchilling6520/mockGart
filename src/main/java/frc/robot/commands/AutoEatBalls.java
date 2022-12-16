// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsys;

public class AutoEatBalls extends CommandBase {
  /** Creates a new IntakeCmd. */
  private IntakeSubsys m_intake = new IntakeSubsys();
  private final double _intakeSpeed;
  public AutoEatBalls(IntakeSubsys intake, double speed) {
    m_intake = intake;
    addRequirements(m_intake);
    _intakeSpeed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.rotate(_intakeSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.rotate(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.IntakeSubsys;
import static frc.robot.Constants.*;

public class IntakeCmd extends CommandBase {
  /** Creates a new IntakeCmd. */
  private IntakeSubsys m_intake = new IntakeSubsys();
  public IntakeCmd(IntakeSubsys intake) {
    m_intake = intake;
    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putBoolean("Intake Running?", true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.rotate(INTAKESPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.rotate(0.0);
    SmartDashboard.putBoolean("Intake Running?", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;//new JoystickButton(joystick, 1).;
  }
}

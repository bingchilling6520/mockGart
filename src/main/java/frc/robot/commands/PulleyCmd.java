// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PulleySubsys;
import static frc.robot.Constants.buttonID.*;

import static frc.robot.Constants.*;

public class PulleyCmd extends CommandBase {
  /** Creates a new PulleyCmd. */
  private PulleySubsys m_pulley = new PulleySubsys();
  private double speed = PULLEYSPEED;
  private double speedMode = 0.1;

  public PulleyCmd(PulleySubsys __pulley) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pulley = __pulley;
  }
  public PulleyCmd setSpeed(double __speed)
  {
    speedMode = __speed;
    return this;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // SmartDashboard.putNumber("Pulley Speed", PULLEYSPEED);
    SmartDashboard.putBoolean("Pulley Running?", true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speed = SmartDashboard.getNumber("Pulley Speed", PULLEYSPEED);
    m_pulley.pull(speed * speedMode * (JOYSTICK2.getRawAxis(INVERT) > 0 ? -1 : 1));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_pulley.pull(0.0);
    SmartDashboard.putBoolean("Pulley Running?", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

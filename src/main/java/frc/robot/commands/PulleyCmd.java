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
  private PulleySubsys m_pulley;

  public PulleyCmd(PulleySubsys __pulley) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pulley = __pulley;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // SmartDashboard.putNumber("Pulley Speed", PULLEYSPEED);
    m_pulley.isPulleyRunning = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = (JOYSTICK2.getRawAxis(BOOSTPULLEY) > SENSIVITY ?
                      SmartDashboard.getNumber("Pulley Fast Speed", PULLEYFASTSPEED) :
                      SmartDashboard.getNumber("Pulley Slow Speed", PULLEYSLOWSPEED))
                      * (JOYSTICK2.getRawAxis(INVERT) > SENSIVITY ? -1 : 1);
    m_pulley.pull(speed, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_pulley.pull(0.0, 0.0);
    m_pulley.isPulleyRunning = false;
  }

  // Returns true when the command should end.k
  @Override
  public boolean isFinished() {
    return false;
  }
}

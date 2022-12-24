// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriverBaseSubsys;
import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
  
public class DriverBaseCmd extends CommandBase {
  /** Creates a new RobotBase. */
  private DriverBaseSubsys m_subsystem = new DriverBaseSubsys();
  public DriverBaseCmd(DriverBaseSubsys subsystem) {
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {} //empty

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double mult = (JOYSTICK.getRawAxis(RIGHTTRIGGER)>0)? NORMSPEED : SLOWSPEED;
    m_subsystem.drive(mult*JOYSTICK.getRawAxis(YAXISLEFT),mult*JOYSTICK.getRawAxis(YAXISRIGHT));
    SmartDashboard.putNumber("Left Speed", mult*JOYSTICK.getRawAxis(YAXISLEFT));
    SmartDashboard.putNumber("Right Speed", mult*JOYSTICK.getRawAxis(YAXISRIGHT));
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.drive(0.0,0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
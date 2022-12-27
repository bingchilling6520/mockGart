// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Algorithm.RunningMode;
import frc.robot.subsystems.DriverBaseSubsys;
import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
  
public class DriverBaseCmd extends CommandBase {
  /** Creates a new RobotBase. */
  private DriverBaseSubsys m_subsystem = new DriverBaseSubsys();
  private double slowSpeed = SLOWSPEED, boostSpeed = BOOSTSPEED;
  
  public DriverBaseCmd(DriverBaseSubsys subsystem) {
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  } //empty

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    slowSpeed = SmartDashboard.getNumber("Driverbase Normal Speed", SLOWSPEED);
    boostSpeed = SmartDashboard.getNumber("Driverbase Boosted Speed", BOOSTSPEED);
     double multright = (JOYSTICK.getRawAxis(BOOST)>0)? boostSpeed : slowSpeed, 
            multleft = (JOYSTICK.getRawAxis(BOOST)>0)? boostSpeed : slowSpeed;
    m_subsystem.drive(multleft*JOYSTICK.getRawAxis(YAXISLEFT),multright*JOYSTICK.getRawAxis(YAXISRIGHT));
    SmartDashboard.putNumber("Left Speed", multleft*JOYSTICK.getRawAxis(YAXISLEFT));
    SmartDashboard.putNumber("Right Speed", multright*JOYSTICK.getRawAxis(YAXISRIGHT));
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.drive(0.0,0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //return true ìf MODE != RunningMode.teleOperated;
    return MODE != RunningMode.teleOperated;
  }
}
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriverBaseSubsys;
import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.lang.Math;
  
public class DriverBaseCmd extends CommandBase {
  /** Creates a new RobotBase. */
  private DriverBaseSubsys m_subsystem = new DriverBaseSubsys();
  private double slowSpeed = NORMSPEED, boostSpeed = BOOSTSPEED;
  
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
    int pov = JOYSTICK.getPOV();
    if (pov!=-1) //POV pressed drive with NORMSPEED constants
    {
      switch (pov)
      {
        case 0: //up
          m_subsystem.drive(NORMSPEED, NORMSPEED);
          break;
        case 90: //right
          //m_subsystem.drive(NORMSPEED, -NORMSPEED);
          break;
        case 180: //down
          m_subsystem.drive(-NORMSPEED, -NORMSPEED);
          break;
        case 270: //left
          //m_subsystem.drive(-NORMSPEED, NORMSPEED);
          break;
      }
      return;
    }
    // Y axises are inverted for Playstation controller (quick and dirty fix)
    double rawAxisLeft = -JOYSTICK.getRawAxis(YAXISLEFT);
    double rawAxisRight = -JOYSTICK.getRawAxis(YAXISRIGHT);
    
    if (Math.abs(rawAxisLeft)<=0 && Math.abs(rawAxisRight)<=0) //no joystick movement
    {
      return;
    }
    
    slowSpeed = SmartDashboard.getNumber("Driverbase Normal Speed", NORMSPEED);
    boostSpeed = SmartDashboard.getNumber("Driverbase Boosted Speed", BOOSTSPEED);
     double multright = (JOYSTICK.getRawAxis(BOOST)>0)? boostSpeed : slowSpeed, 
            multleft = (JOYSTICK.getRawAxis(BOOST)>0)? boostSpeed : slowSpeed;
    m_subsystem.drive(multleft*rawAxisLeft,multright*rawAxisRight);
    SmartDashboard.putNumber("Left Speed", multleft*rawAxisLeft);
    SmartDashboard.putNumber("Right Speed", multright*rawAxisRight);
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
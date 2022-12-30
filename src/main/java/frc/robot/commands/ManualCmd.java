// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriverBaseSubsys;
import frc.robot.subsystems.PulleySubsys;

import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.lang.Math;
import static frc.robot.Algorithm.*;
  
public class ManualCmd extends CommandBase {
  /** Creates a new RobotBase. */
  private DriverBaseSubsys m_driverBaseSubsystem;
  private PulleySubsys m_pulleySubsystem;
  private double slowSpeed = NORMSPEED, boostSpeed = BOOSTSPEED;
  
  public ManualCmd(DriverBaseSubsys driverBaseSubsystem, PulleySubsys pulleySubsystem) {
    m_driverBaseSubsystem = driverBaseSubsystem;
    m_pulleySubsystem = pulleySubsystem;
    addRequirements(m_driverBaseSubsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  } //empty

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    //Y axis on joystick are reversed
    double pulleyLeft = -JOYSTICK2.getRawAxis(YAXISLEFT2);
    double pulleyRight = -JOYSTICK2.getRawAxis(YAXISRIGHT2);
    //No joystick movement
    if (Math.abs(pulleyLeft)<=SENSIVITY && Math.abs(pulleyRight)<=SENSIVITY) 
    {
      m_pulleySubsystem.isPulleyRunningSereparetly = false;
    }
    else
    {
      m_pulleySubsystem.pull(unitary(pulleyLeft), unitary(pulleyRight));
      m_pulleySubsystem.isPulleyRunningSereparetly = true;
    }
    slowSpeed = SmartDashboard.getNumber("Driverbase Normal Speed", NORMSPEED);
    boostSpeed = SmartDashboard.getNumber("Driverbase Boosted Speed", BOOSTSPEED);
    int pov = JOYSTICK.getPOV();
    if (pov!=-1) //POV pressed drive with NORMSPEED constants
    {
      switch (pov)
      {
        case 0: //up
          m_driverBaseSubsystem.drive(slowSpeed, slowSpeed);
          break;
        case 90: //right
          //m_subsystem.drive(NORMSPEED, -NORMSPEED);
          break;
        case 180: //down
          m_driverBaseSubsystem.drive(-slowSpeed, -slowSpeed);
          break;
        case 270: //left
          //m_subsystem.drive(-NORMSPEED, NORMSPEED);
          break;
      }
      return;
    }
    // Y axises are inverted for Playstation controller (quick and dirty fix)
    double rawAxisLeft = -JOYSTICK.getRawAxis(YAXISLEFT1);
    double rawAxisRight = -JOYSTICK.getRawAxis(YAXISRIGHT1);
    
    if (Math.abs(rawAxisLeft)<=SENSIVITY && Math.abs(rawAxisRight)<=SENSIVITY) //no joystick movement
    {
      return;
    }
    
     double multright = (JOYSTICK.getRawAxis(BOOST)>0)? boostSpeed : slowSpeed, 
            multleft = (JOYSTICK.getRawAxis(BOOST)>0)? boostSpeed : slowSpeed;
    m_driverBaseSubsystem.drive(multleft*rawAxisLeft,multright*rawAxisRight);
    SmartDashboard.putNumber("Left Speed", multleft*rawAxisLeft);
    SmartDashboard.putNumber("Right Speed", multright*rawAxisRight);
  }

  @Override
  public void end(boolean interrupted) {
    m_driverBaseSubsystem.drive(0.0,0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
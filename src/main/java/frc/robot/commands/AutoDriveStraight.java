// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriverBaseSubsys;
  
public class AutoDriveStraight extends CommandBase {
  /** Creates a new RobotBase. */
  private DriverBaseSubsys m_driverBaseSubsystem = new DriverBaseSubsys();
  private double speed;
  public AutoDriveStraight(DriverBaseSubsys subsystem, double _speed) {
    m_driverBaseSubsystem = subsystem;
    addRequirements(m_driverBaseSubsystem);
    speed=_speed;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {} //empty

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driverBaseSubsystem.drive(speed, speed);
  } //empty

  @Override
  public void end(boolean interrupted) {
    m_driverBaseSubsystem.drive(0.0,0.0);
  } //empty

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

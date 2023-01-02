package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsys;
  
public class AutoDriveStraight extends CommandBase {
  private DriveBaseSubsys m_driveBase;
  private double speed;
  public AutoDriveStraight(DriveBaseSubsys __subsystem, double __speed) {
    m_driveBase = __subsystem;
    addRequirements(m_driveBase);
    speed=__speed;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {} //empty

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveBase.drive(speed, speed);
  } //empty

  @Override
  public void end(boolean interrupted) {
    m_driveBase.drive(0.0,0.0);
  } //empty

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

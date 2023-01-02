package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsys;

import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.lang.Math;
  
public class DriveBaseCmd extends CommandBase {
  /** Creates a new RobotBase. */
  private DriveBaseSubsys m_driverBase;
  
  public DriveBaseCmd(DriveBaseSubsys __subsystem) {
    m_driverBase = __subsystem;
    addRequirements(m_driverBase);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {} //empty

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if (JOYSTICK1.getRawButton(PRECISETURNBUTTON1))
    {
      return;
    }
    double slowSpeed = SmartDashboard.getNumber("Driverbase Normal Speed", NORMSPEED),
           boostSpeed = SmartDashboard.getNumber("Driverbase Boosted Speed", BOOSTSPEED);

    int pov = JOYSTICK1.getPOV();
    if (pov != -1) //POV pressed drive with NORMSPEED constants
    {
      switch (pov)
      {
        case 0: //up
          m_driverBase.drive(slowSpeed, slowSpeed);
          break;
        case 180: //down
          m_driverBase.drive(-slowSpeed, -slowSpeed);
          break;
      }
      return;
    }

    // Y axises are inverted for Playstation controller (quick and dirty fix)
    double rawAxisLeft = -JOYSTICK1.getRawAxis(YAXISLEFT1);
    double rawAxisRight = -JOYSTICK1.getRawAxis(YAXISRIGHT1);

    if (Math.abs(rawAxisLeft) <= SENSITIVITY && Math.abs(rawAxisRight) <= SENSITIVITY) // no joystick movement
    {
      m_driverBase.drive(0.0, 0.0);
      return;
    }
    
    double leftSpeed = rawAxisLeft *  ((JOYSTICK1.getRawAxis(BOOST) > 0) ? boostSpeed : slowSpeed), 
           rightSpeed = rawAxisRight * ((JOYSTICK1.getRawAxis(BOOST) > 0) ? boostSpeed : slowSpeed);
    
    m_driverBase.drive(leftSpeed, rightSpeed);
    
    SmartDashboard.putNumber("Left Speed", leftSpeed);
    SmartDashboard.putNumber("Right Speed", rightSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_driverBase.drive(0.0,0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

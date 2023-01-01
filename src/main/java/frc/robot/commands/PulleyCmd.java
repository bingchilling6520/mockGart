package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PulleySubsys;
import static frc.robot.Constants.buttonID.*;

import static frc.robot.Constants.*;

public class PulleyCmd extends CommandBase {
  /** Creates a new PulleyCmd. */
  private PulleySubsys m_pulley;

  public PulleyCmd(PulleySubsys __subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pulley = __subsystem;
    addRequirements(m_pulley);
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
    double speed = (JOYSTICK2.getRawAxis(BOOSTPULLEY) > SENSITIVITY ?
                      SmartDashboard.getNumber("Pulley Fast Speed", PULLEYFASTSPEED) :
                      SmartDashboard.getNumber("Pulley Slow Speed", PULLEYSLOWSPEED))
                      * (JOYSTICK2.getRawAxis(INVERT) > SENSITIVITY ? -1 : 1);
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

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.PulleySubsys;
import static frc.robot.Algorithm.*;
import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;

public class PulleyManCmd extends CommandBase {
  /** Creates a new PulleyManCmd. */

  private PulleySubsys m_pulley;

  public PulleyManCmd(PulleySubsys __subsystem) {
    m_pulley = __subsystem;
    addRequirements(m_pulley);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Y axis on joystick are reversed
    double pulleyLeft = -JOYSTICK2.getRawAxis(YAXISLEFT2);
    double pulleyRight = -JOYSTICK2.getRawAxis(YAXISRIGHT2);

    double mult = JOYSTICK2.getRawAxis(BOOSTPULLEY) > 0 ?
                      SmartDashboard.getNumber("Pulley Fast Speed", PULLEYFASTSPEED) :
                      SmartDashboard.getNumber("Pulley Slow Speed", PULLEYSLOWSPEED);
    
    if (Math.abs(pulleyLeft) > JOYSTICKSENSITIVITY || Math.abs(pulleyRight) > JOYSTICKSENSITIVITY)
    {
      m_pulley.pull(mult * signOf(pulleyLeft), mult * signOf(pulleyRight));
    }

    else
    {
      m_pulley.pull(0.0, 0.0);
    }
  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_pulley.pull(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

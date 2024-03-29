package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsys;
import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;

public class IntakeCmd extends CommandBase {
  /** Creates a new IntakeCmd. */
  private IntakeSubsys m_intake;
  public IntakeCmd(IntakeSubsys __subsystem) {
    m_intake = __subsystem;
    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putBoolean("Intake Running?", true);
  }

  @Override
  public void execute()
  {
    m_intake.rotate(INTAKESPEED * (JOYSTICK2.getRawAxis(INVERT) > SENSITIVITY ? -1 : 1));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.rotate(0.0);
    SmartDashboard.putBoolean("Intake Running?", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;//new JoystickButton(joystick, 1).;
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TrapDoorSubsys;
import static frc.robot.Constants.*;
import static frc.robot.Constants.buttonID.*;
import static frc.robot.Constants.talonID.*;

public class TrapDoorCmd extends CommandBase {
  /** true = open, false = close */
  private boolean state = false; 
  private TrapDoorSubsys m_trapDoor;
  /** Creates a new TrapDoorCmd. */
  public TrapDoorCmd(TrapDoorSubsys __subsystem) {
      m_trapDoor = __subsystem;
      addRequirements(m_trapDoor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("CLOSE THE TRAPDOOR BEFORE RUNNING");
    state = !state;
    state = SmartDashboard.putBoolean((m_trapDoor.id == FRONTTRAPDOORID ? "Front" : "Back") + " Trap Door Open?", state);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_trapDoor.rotate(SmartDashboard.getNumber("Trap Door Speed", TRAPDOORSPEED) *
                     (JOYSTICK2.getRawAxis(INVERT) > SENSITIVITY ? -1 : 1));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_trapDoor.rotate(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

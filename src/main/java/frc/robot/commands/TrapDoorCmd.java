// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TrapDoorSubsys;
import static frc.robot.Constants.*;

public class TrapDoorCmd extends CommandBase {
  /** true = open, false = close */
  private boolean state = false; 
  private TrapDoorSubsys m_trapDoorSubsystem;
  /** Creates a new TrapDoorCmd. */
  public TrapDoorCmd(TrapDoorSubsys __trapDoorSubsystem) {
      m_trapDoorSubsystem = __trapDoorSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    state = !state;
    SmartDashboard.putBoolean("Trapdoor Open?", state);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_trapDoorSubsystem.rotate(TRAPDOORSPEED * (state ? 1 : - 1));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_trapDoorSubsystem.rotate(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

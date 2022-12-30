// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TrapDoorSubsys;
//import static frc.robot.Constants.*;

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
    System.out.println("CLOSE THE TRAPDOOR BEFORE RUNNING");
    state = !state;
    state = SmartDashboard.putBoolean(m_trapDoorSubsystem.channel == 0 ? "Front" : "Back" + " Trap Door Open?", state);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //SmartDashboard.putNumber("Trap Door Speed", TRAPDOORSPEED);
    state = SmartDashboard.getBoolean(m_trapDoorSubsystem.channel == 0 ? "Front" : "Back" + " Trap Door Open?", state);
    //speed = SmartDashboard.getNumber("Trap Door Speed", TRAPDOORSPEED);
    m_trapDoorSubsystem.setAngle(state ? 180 : 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true; //instant command
  }
}

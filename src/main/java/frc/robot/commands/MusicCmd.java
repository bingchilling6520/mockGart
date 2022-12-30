// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PulleySubsys;

public class MusicCmd extends CommandBase {
  /** Creates a new MusicCmd. */
  private PulleySubsys m_music;
  public MusicCmd(PulleySubsys __music) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_music=__music;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    System.out.println("Music CMD");
    m_music.updateMusic();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}

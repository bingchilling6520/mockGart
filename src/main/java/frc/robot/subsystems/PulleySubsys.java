// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

import static frc.robot.Constants.talonID.*;

public class PulleySubsys extends SubsystemBase {
  /** Creates a new PulleySubsys. */
  private final WPI_TalonFX rightPulley = new WPI_TalonFX(RIGHTPULLEYID),
                            leftPulley = new WPI_TalonFX(LEFTPULLEYID);
  private Orchestra music = new Orchestra();
  public boolean isPulleyRunning = false;
  
  public PulleySubsys() {
    // Rotate with equal but opposite velocity.
    leftPulley.setInverted(true);

    // Music
    music.addInstrument(leftPulley);
    music.addInstrument(rightPulley);
    updateMusic();
  }
  public void updateMusic()
  {
    System.out.println(SmartDashboard.getString("Music File", "song1.chrp") + " " + music.isPlaying());
    music.loadMusic(SmartDashboard.getString("Music File", "song1.chrp"));
    music.play();
    
  }
  public void pull(double leftSpeed, double rightSpeed)
  {
    leftPulley.set(leftSpeed);
    rightPulley.set(rightSpeed);
    SmartDashboard.putBoolean("Pulley Running?", (leftSpeed > 0) || (rightSpeed > 0));
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Pulley Temperature", leftPulley.getTemperature());
    SmartDashboard.putNumber("Right Pulley Temperature", rightPulley.getTemperature());
  }
}

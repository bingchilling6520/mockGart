// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

import static frc.robot.Constants.talonID.*;

public class PulleySubsys extends SubsystemBase {
  /** Creates a new PulleySubsys. */
  private final WPI_TalonFX rightPulley = new WPI_TalonFX (RIGHTPULLEYID),
                          leftPulley = new WPI_TalonFX(LEFTPULLEYID);
  private Orchestra music = new Orchestra();
  
  //private final WPI_TalonSRX pulley = new WPI_TalonSRX(PULLEYID);
  
  public PulleySubsys() {
    //Rotate with equal but opposite velocity.
    leftPulley.setInverted(true);
    music.addInstrument(leftPulley);
    music.addInstrument(rightPulley);
    music.loadMusic("song1.chrp");
    music.play();
  }

  public void pull(double speed)
  {
    leftPulley.set(speed);
    rightPulley.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

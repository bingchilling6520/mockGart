// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.talonID.*;

public class PulleySubsys extends SubsystemBase {
  /** Creates a new PulleySubsys. */
  /*private final WPI_TalonSRX rightPulley = new WPI_TalonSRX (RIGHTPULLEYID),
                          leftPulley = new WPI_TalonSRX(LEFTPULEYID);*/
  
  private final WPI_TalonSRX pulley = new WPI_TalonSRX(RIGHTPULLEYID);
  
  public PulleySubsys() {
    //Rotate with equal but opposite velocity.
    //leftPulley.follow(rightPulley);
    pulley.setInverted(true);
  }

  public void pull(double speed)
  {
    pulley.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

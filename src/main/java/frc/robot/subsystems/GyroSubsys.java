// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

public class GyroSubsys extends SubsystemBase {
  
  private AHRS ahrs = new AHRS();
  private static GyroSubsys gyro = new GyroSubsys ();

  public GyroSubsys getInstance()
  {
    return gyro;
  }

  public void reset()
  {
    ahrs.reset();
  }

  public double getYaw()
  {
    return ahrs.getYaw();
  }

  public GyroSubsys() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    float vx = ahrs.getVelocityX();
    float vy = ahrs.getVelocityY();
    float vz = ahrs.getVelocityZ();

    SmartDashboard.putNumber("X velocity", vx);
    SmartDashboard.putNumber("Y velocity", vy);
    SmartDashboard.putNumber("Z velocity", vz);
    SmartDashboard.putBoolean("Drivebase moving?", (vx == 0 && vy == 0));
  }
}

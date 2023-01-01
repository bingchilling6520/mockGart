// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Servo;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

  /** Channel 0 is Front, Channel 1 is Back. */
public class TrapDoorSubsys extends SubsystemBase {
  private Servo trapDoor;
  public int channel;
  public TrapDoorSubsys(int __channel) {
      trapDoor = new Servo(__channel);
      channel = __channel;
  }

  /**False = close, True = open*/
  public void rotate(double speed)
  {
    trapDoor.setAngle(90 + speed * 90);
  }
  @Override
  public void periodic() {} //empty
}

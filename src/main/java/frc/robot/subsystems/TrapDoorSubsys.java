// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import static frc.robot.Constants.talonID.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TrapDoorSubsys extends SubsystemBase {
  /** Creates a new TrapDoorSubsys. */
  private WPI_VictorSPX trapDoor = new WPI_VictorSPX(TRAPDOORID);
  public TrapDoorSubsys() {}

  public void rotate (double speed)
  {
      trapDoor.set(speed);
  }
  @Override
  public void periodic() {

  }
}

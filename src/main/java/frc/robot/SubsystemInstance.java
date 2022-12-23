// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriverBaseSubsys;
import frc.robot.subsystems.GyroSubsys;
import frc.robot.subsystems.IntakeSubsys;
import frc.robot.subsystems.PIDControllerSubsys;
import frc.robot.subsystems.PulleySubsys;
import frc.robot.subsystems.TrapDoorSubsys;

/** A class to access the instance of subsystem. */
public final class SubsystemInstance {
      public static final DriverBaseSubsys m_driverBaseSubsystem = new DriverBaseSubsys();
      public static final IntakeSubsys m_intakeSubsystem = new IntakeSubsys();
      public static final PIDControllerSubsys m_PIDSubsystem = new PIDControllerSubsys();
      public static final GyroSubsys m_gyroSubsystem = new GyroSubsys();
      public static final PulleySubsys m_pulleySubsystem = new PulleySubsys();
      public static final TrapDoorSubsys m_trapDoorSubsystem = new TrapDoorSubsys();

}

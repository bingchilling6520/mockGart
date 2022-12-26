// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDriveStraight;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.PulleyCmd;
import frc.robot.subsystems.DriverBaseSubsys;
import frc.robot.subsystems.IntakeSubsys;
import frc.robot.subsystems.PulleySubsys;
import frc.robot.subsystems.TrapDoorSubsys;
import static frc.robot.Constants.SubsystemInstance.*;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *0
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants{
      public final static class SubsystemInstance
      {
            public final static DriverBaseSubsys m_driverBaseSubsystem = new DriverBaseSubsys();
            public final static IntakeSubsys m_intakeSubsystem = new IntakeSubsys();
            public final static IntakeCmd m_intakeCommand = new IntakeCmd(m_intakeSubsystem);
            public final static PulleySubsys m_pulleySubsystem = new PulleySubsys();
            public final static TrapDoorSubsys m_trapDoorSubsystem = new TrapDoorSubsys();
      }
      public static final double BOOSTSPEED = 0.8, SLOWSPEED = 0.4, INTAKESPEED = 1, PULLEYSPEED = 1, TRAPDOORSPEED = 0.2;
      
      public static final double TRAPDOORDURATION = 0.2;

      public final class buttonID
      {
            public static final int YAXISLEFT = 1, YAXISRIGHT = 5, 
                                    INVERT = 3, BOOST = 4, 
                                    //LEFTBRAKE = 5, RIGHTBRAKE = 6,
                                    INTAKEBUTTON = 1, PULLEYBUTTON = 2, TRAPDOORBUTTON = 3;
      }
      
      public final class talonID
      {
            public static final int RIGHTMASTERID = 1, RIGHTFOLLOWID = 2,
                                    LEFTMASTERID = 3, LEFTFOLLOWID = 4,
                                    INTAKEID = 5,
                                    PULLEYID = 6, RESERVE = 7, // Currently 7 is reserved for future use
                                    TRAPDOORID = 8; // Trap door use Victor
      }
      
      public final static class PID
      {
            public static final double KI = 0, KP = 1.0/18, KD = 0, KTOLERANCE = 2.0, KTOLERANCEVELOCITY = 0.8 ;
      }
      public final static class autoCmd
      {
            // Drive Straight quickly for 0.5s then move slowly while eating balls in 0.8s
            public static final Command TESTCMD = 
            new SequentialCommandGroup(
                  new AutoDriveStraight(m_driverBaseSubsystem,BOOSTSPEED).withTimeout(0.5),
                  new ParallelCommandGroup(
                        new AutoDriveStraight(m_driverBaseSubsystem, SLOWSPEED),
                        new IntakeCmd(m_intakeSubsystem),
                        new PulleyCmd(m_pulleySubsystem)
                  ).withTimeout(0.8));
      }
      public final static Joystick JOYSTICK = new Joystick(0);
}

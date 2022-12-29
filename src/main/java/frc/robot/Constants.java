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
public final class Constants {
      public final static class SubsystemInstance
      {
            public final static DriverBaseSubsys m_driverBaseSubsystem = new DriverBaseSubsys();
            public final static IntakeSubsys m_intakeSubsystem = new IntakeSubsys();
            public final static PulleySubsys m_pulleySubsystem = new PulleySubsys();
            public final static TrapDoorSubsys m_trapDoorSubsystem = new TrapDoorSubsys();
      }

      public static final double BOOSTSPEED = 0.8,      // Driverbase boost speed
                                 SLOWSPEED = 0.4,       // Driverbase slow speed
                                 INTAKESPEED = 1,       // Intake speed (max, 1:48 SIM motor)
                                 TRAPDOORSPEED = 0.2,   // Trapdoor speed (on the future this might switch to a servo)
                                 PULLEYSLOWSPEED = 0.1, // Pulley slow speed
                                 PULLEYFASTSPEED = 0.3; // Pulley fast speed
      
      public static final double NORMSPEED = SLOWSPEED; // Default speed

      public static final double TRAPDOORDURATION = 0.2;

      public final class buttonID
      {
            public static final int // Axis
                                    YAXISLEFT = 1,      // Left joystick
                                    YAXISRIGHT = 5,     // Right joystick
                                    BOOST = 4,          // Driverbase boost button, on the first controller
                                    
                                    INVERT = 3,         // Intake & pulley invert button, on the second controller
                                    BOOSTPULLEY = 4,    // Pulley boost button, on the second controller

                                    // Button
                                    INTAKEBUTTON = 5,   // Intake button, on the second controller
                                    PULLEYBUTTON = 6,   // Pulley button, on the second controller
                                    TRAPDOORBUTTON = 3; // Trap door button, on the second controller
      }
      
      public final class talonID
      {
            public static final int RIGHTMASTERID = 1,  // First motor on the right side
                                    RIGHTFOLLOWID = 2,  // Second motor on the right side
                                    LEFTMASTERID = 3,   // First motor on the left side
                                    LEFTFOLLOWID = 4,   // Second motor on the left side

                                    INTAKEID = 5,       // Intake motor
                                    LEFTPULLEYID = 6,   // Left pulley use Falcon (TalonFX based)
                                    RIGHTPULLEYID = 7,  // Right pulley use Falcon (TalonFX based)
                                    TRAPDOORID = 8;     // Trap door use Victor (might change to servo in the future)
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

      /** Driverbase control joystick */
      public final static Joystick JOYSTICK = new Joystick(0);  
      
      /** Features/mechanism control joystick */
      public final static Joystick JOYSTICK2 = new Joystick(1); 
}

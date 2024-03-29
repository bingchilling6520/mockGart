package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDriveStraight;
import frc.robot.commands.AutoRotateToAngle;
import frc.robot.subsystems.DriveBaseSubsys;
import frc.robot.subsystems.GyroSubsys;
import frc.robot.subsystems.IntakeSubsys;
import frc.robot.subsystems.PIDControllerSubsys;
import frc.robot.subsystems.PulleySubsys;
import frc.robot.subsystems.TrapDoorSubsys;
import static frc.robot.Constants.SingleInstance.*;
import static frc.robot.Constants.talonID.*;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
      public final static class SingleInstance
      {
            public final static DriveBaseSubsys m_driveBaseSubsystem = new DriveBaseSubsys();
            public final static IntakeSubsys m_intakeSubsystem = new IntakeSubsys();
            public final static PulleySubsys m_pulleySubsystem = new PulleySubsys();
            public final static TrapDoorSubsys m_frontTrapDoorSubsystem = new TrapDoorSubsys(FRONTTRAPDOORID);
            public final static TrapDoorSubsys m_backTrapDoorSubsystem = new TrapDoorSubsys(BACKTRAPDOORID);
            
            public final static GyroSubsys GYRO = new GyroSubsys();
            public final static PIDControllerSubsys PIDCONTROLLER = new PIDControllerSubsys();
      }

      public static final double BOOSTSPEED = 0.8,                // Driverbase boost speed
                                 NORMSPEED = 0.4,                 // Driverbase slow speed
                                 INTAKESPEED = 1,                 // Intake speed (max, 1:48 SIM motor)
                                 PULLEYSLOWSPEED = 0.15,          // Pulley slow speed
                                 PULLEYFASTSPEED = 0.4,           // Pulley fast speed
                                 TRAPDOORSPEED = 0.3;             // Trap Door speed

      /** Sensitivity to account for joystick don't return 0 when not moving */
      public static final double SENSITIVITY = 0.1;
      public static final double JOYSTICKSENSITIVITY = 0.2;

      public final class buttonID
      {
            public static final int // Axis
                                    YAXISLEFT1 = 1,               // Left joystick on the first controller
                                    YAXISRIGHT1 = 5,              // Right joystick on the first controller
                                    XAXISRIGHT1 = 2,              // Right joystick on the first controller
                                    YAXISLEFT2 = 1,               // Left joystick on the second controller
                                    YAXISRIGHT2 = 5,              // Right joystick on the second controller
                                    BOOST = 4,                    // Driverbase and pulley boost button, on the first controller
                                    INVERT = 3,                   // Intake & pulley invert button, on the second controller
                                    BOOSTPULLEY = 4,              // Pulley boost button, on the second controller

                                    // Button
                                    PRECISETURNBUTTON1 = 7,       // Held all buttons to enable precsise 
                                    PRECISETURNBUTTON2 = 8,       // turn, on the first controller
                                    PRECISETURNBUTTON3 = 3,       //
                                    INTAKEBUTTON = 5,             // Intake button, on the second controller
                                    PULLEYBUTTON = 6,             // Pulley button, on the second controller
                                    FRONTTRAPDOORBUTTON = 1,      // Front Trap door button, on the second controller
                                    BACKTRAPDOORBUTTON = 2,       // Back Trap door button, on the second controller
                                    CANCELALLBUTTON1 = 9,
                                    CANCELALLBUTTON2 = 10;
      }
      
      public final class talonID
      {
            public static final int RIGHTMASTERID = 1,            // First motor on the right side
                                    RIGHTFOLLOWID = 2,            // Second motor on the right side
                                    LEFTMASTERID = 3,             // First motor on the left side
                                    LEFTFOLLOWID = 4,             // Second motor on the left side

                                    INTAKEID = 5,                 // Intake motor
                                    LEFTPULLEYID = 6,             // Left pulley use Falcon (TalonFX based)
                                    RIGHTPULLEYID = 7,            // Right pulley use Falcon (TalonFX based)
                                    FRONTTRAPDOORID = 8,          // Front Trap door use Victor SPX
                                    BACKTRAPDOORID = 9;           // Back Trap door use Victor SPX
      }
      
      public final static class PID
      {
            public static final double KI = 0.4, KP = 0.3, KD = 0.05, 
                                       KTOLERANCE = 1.5, KTOLERANCEVELOCITY = 0.8 ;
      }

      public final static class autoCmd
      {
            /** Drive Straight quickly for 0.5s then move slowly while eating balls in 0.8s */
            public static final Command AUTOCMD = 
            new SequentialCommandGroup(
                  new AutoDriveStraight(m_driveBaseSubsystem, 0.8).withTimeout(5.0));

            /**Drive Straight for 0.5s turn by 90 degree then Drive Straight in that direction */
            public static final Command AUTOTURNTESTCMD =
            new SequentialCommandGroup(
                  new AutoRotateToAngle(m_driveBaseSubsystem, 90)
            );
      }

      /** Driverbase control joystick */
      public final static Joystick JOYSTICK1 = new Joystick(0);  
      
      /** Features/mechanism control joystick */
      public final static Joystick JOYSTICK2 = new Joystick(1);
}

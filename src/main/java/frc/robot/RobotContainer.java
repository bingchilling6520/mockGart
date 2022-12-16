package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.commands.DriveStraight;
import frc.robot.subsystems.DriverBaseSubsys;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;   
import static frc.robot.Constants.*;          
import frc.robot.commands.DriverBaseCmd;   
import frc.robot.subsystems.IntakeSubsys;
import static frc.robot.Constants.buttonID.*;
import frc.robot.commands.AutoDriveStraight;
import frc.robot.commands.AutoEatBalls;
import frc.robot.commands.IntakeCmd;                                            

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriverBaseSubsys m_driverBaseSubsystem = new DriverBaseSubsys();
  private final DriverBaseCmd m_driverBaseCommand = new DriverBaseCmd(m_driverBaseSubsystem);
  private final IntakeSubsys m_intakeSubsystem = new IntakeSubsys();
  private final IntakeCmd m_intakeCommand = new IntakeCmd(m_intakeSubsystem);
  
  private final JoystickButton buttonA = new JoystickButton(JOYSTICK, INTAKEBUTTON);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    Trigger trig = new Trigger(() -> true);
    trig.whileActiveContinuous(m_driverBaseCommand);
    buttonA.whenHeld(m_intakeCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   // Drive Straight quickly for 0.5s then move slowly while eating balls in 0.8s
   return new SequentialCommandGroup(
    new AutoDriveStraight(m_driverBaseSubsystem,FASTSPEED).withTimeout(0.5),
    new ParallelCommandGroup(
      new AutoDriveStraight(m_driverBaseSubsystem, NORMSPEED),
      new AutoEatBalls(m_intakeSubsystem,INTAKESPEED)
    ).withTimeout(0.8));
  }
}

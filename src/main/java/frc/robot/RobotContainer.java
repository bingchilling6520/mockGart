package frc.robot;

// FRC libraries
import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.commands.DriveStraight;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj2.command.button.Trigger;   

// Robot subsystems and commands
import static frc.robot.Constants.*;     
import static frc.robot.Constants.buttonID.*;
import static frc.robot.Constants.autoCmd.*;
import static frc.robot.Constants.SubsystemInstance.*;

import frc.robot.commands.DriverBaseCmd;

import frc.robot.commands.IntakeCmd;                                            

import frc.robot.commands.PulleyCmd;

import frc.robot.commands.TrapDoorCmd;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriverBaseCmd m_driverBaseCommand = new DriverBaseCmd(m_driverBaseSubsystem);
  private final IntakeCmd m_intakeCommand = new IntakeCmd(m_intakeSubsystem);
  private final PulleyCmd m_pulleyCommand = new PulleyCmd(m_pulleySubsystem);
  private final TrapDoorCmd m_trapDoorCommand = new TrapDoorCmd(m_trapDoorSubsystem);
  
  private final JoystickButton buttonIntake = new JoystickButton(JOYSTICK, INTAKEBUTTON);
  private final JoystickButton buttonPulley = new JoystickButton(JOYSTICK, PULLEYBUTTON);
  private final JoystickButton buttonTrapdoor = new JoystickButton(JOYSTICK, TRAPDOORBUTTON);
  
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    SmartDashboard.putNumber("Pulley Speed", PULLEYSPEED);
    SmartDashboard.putNumber("Intake Speed", INTAKESPEED); 
    SmartDashboard.putNumber("Trap Door Speed", TRAPDOORSPEED); 
    SmartDashboard.putNumber("Driverbase Normal Speed", SLOWSPEED);
    SmartDashboard.putNumber("Driverbase Boosted Speed", BOOSTSPEED);
    SmartDashboard.putBoolean("Intake Running?", false);
    SmartDashboard.putBoolean("Pulley Running?", false);
    SmartDashboard.putBoolean("Trap Door Open?", false);
    
    m_chooser.setDefaultOption("Test", TESTCMD);

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
    //trig.whileActiveContinuous(m_pulleyCommand).whileActiveContinuous(m_intakeCommand);
    buttonIntake.whenHeld(m_intakeCommand);
    buttonPulley.whenHeld(m_pulleyCommand);
    buttonTrapdoor.whenActive(m_trapDoorCommand.withTimeout(TRAPDOORDURATION));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
//    SendableChooser<Command> m27/_chooser = new SendableChooser<>();
//    m_chooser.setDefaultOption("Test", TESTCMD);
   SmartDashboard.putData("Auto Command", m_chooser);
   return m_chooser.getSelected();
  }
}

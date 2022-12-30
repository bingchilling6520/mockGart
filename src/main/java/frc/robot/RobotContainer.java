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

// Robot subsystems and commands
import static frc.robot.Constants.*;     
import static frc.robot.Constants.buttonID.*;
import static frc.robot.Constants.autoCmd.*;
import static frc.robot.Constants.SubsystemInstance.*;

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
  private final IntakeCmd m_intakeCommand = new IntakeCmd(m_intakeSubsystem);
  private final PulleyCmd m_pulleyCommand = new PulleyCmd(m_pulleySubsystem);
  private final TrapDoorCmd m_frontTrapDoorCommand = new TrapDoorCmd(m_frontTrapDoorSubsystem);
  private final TrapDoorCmd m_backTrapDoorCommand = new TrapDoorCmd(m_backTrapDoorSubsystem);
  
  private final JoystickButton buttonIntake = new JoystickButton(JOYSTICK2, INTAKEBUTTON);
  private final JoystickButton buttonPulley = new JoystickButton(JOYSTICK2, PULLEYBUTTON);
  private final JoystickButton frontButtonTrapdoor = new JoystickButton(JOYSTICK2, FRONTTRAPDOORBUTTON);
  private final JoystickButton backButtonTrapdoor = new JoystickButton(JOYSTICK2, BACKTRAPDOORBUTTON);
  
  private final SendableChooser<Command> m_commandChooser = new SendableChooser<>();
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // SmartDashboard initialize
    SmartDashboard.putNumber("Pulley Slow Speed", PULLEYSLOWSPEED);
    SmartDashboard.putNumber("Pulley Fast Speed", PULLEYFASTSPEED);
    SmartDashboard.putNumber("Intake Speed", INTAKESPEED); 
    //SmartDashboard.putNumber("Trap Door Speed", TRAPDOORSPEED); 
    SmartDashboard.putNumber("Driverbase Normal Speed", NORMSPEED);
    SmartDashboard.putNumber("Driverbase Boosted Speed", BOOSTSPEED);
    SmartDashboard.putBoolean("Intake Running?", false);
    SmartDashboard.putBoolean("Pulley Running?", false);
    SmartDashboard.putBoolean("Front Trap Door Open?", false);
    SmartDashboard.putBoolean("Back Trap Door Open?", false);
    SmartDashboard.putBoolean("Trap Door Set State", false);
    SmartDashboard.putString("Music File", "badapple2.chrp");
    m_commandChooser.setDefaultOption("Test", TESTCMD);
    SmartDashboard.putData("Auto Command", m_commandChooser);
    
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
    //trig.whileActiveContinuous(m_pulleyCommand).whileActiveContinuous(m_intakeCommand);
    buttonIntake.whenHeld(m_intakeCommand);
    buttonPulley.whenHeld(m_pulleyCommand);
    frontButtonTrapdoor.whenActive(m_frontTrapDoorCommand);
    backButtonTrapdoor.whenActive(m_backTrapDoorCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // SendableChooser<Command> m_chooser = new SendableChooser<>();
    // m_chooser.setDefaultOption("Test", TESTCMD);
    return m_commandChooser.getSelected();
    //return TESTCMD;
  }
}

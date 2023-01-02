package frc.robot;

// FRC libraries
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// Robot subsystems and commands
import static frc.robot.Constants.*;     
import static frc.robot.Constants.buttonID.*;
import static frc.robot.Constants.autoCmd.*;
import static frc.robot.Constants.SingleInstance.*;

import frc.robot.commands.IntakeCmd;
import frc.robot.commands.PreciseTurnCmd;
import frc.robot.commands.PulleyCmd;
import frc.robot.commands.ResetGyro;
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
  private final PreciseTurnCmd m_preciseTurnCommand = new PreciseTurnCmd(m_driveBaseSubsystem);
  private final ResetGyro m_resetGyroCommand = new ResetGyro();
  
  private final JoystickButton buttonIntake = new JoystickButton(JOYSTICK2, INTAKEBUTTON);
  private final JoystickButton buttonPulley = new JoystickButton(JOYSTICK2, PULLEYBUTTON);
  private final JoystickButton frontButtonTrapdoor = new JoystickButton(JOYSTICK2, FRONTTRAPDOORBUTTON);
  private final JoystickButton backButtonTrapdoor = new JoystickButton(JOYSTICK2, BACKTRAPDOORBUTTON);
  private final JoystickButton preciseTurnButton1 = new JoystickButton(JOYSTICK1, PRECISETURNBUTTON1);
  private final JoystickButton preciseTurnButton2 = new JoystickButton(JOYSTICK1, PRECISETURNBUTTON2);
  
  private final SendableChooser<Command> m_commandChooser = new SendableChooser<>();
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // SmartDashboard initialize
    SmartDashboard.putNumber("Pulley Slow Speed", PULLEYSLOWSPEED);
    SmartDashboard.putNumber("Pulley Fast Speed", PULLEYFASTSPEED);
    SmartDashboard.putNumber("Intake Speed", INTAKESPEED);
    SmartDashboard.putNumber("Trap Door Speed", TRAPDOORSPEED);
    SmartDashboard.putNumber("Driverbase Normal Speed", NORMSPEED);
    SmartDashboard.putNumber("Driverbase Boosted Speed", BOOSTSPEED);
    SmartDashboard.putBoolean("Intake Running?", false);
    SmartDashboard.putBoolean("Pulley Running?", false);
    SmartDashboard.putBoolean("Front Trap Door Open?", false);
    SmartDashboard.putBoolean("Back Trap Door Open?", false);
    SmartDashboard.putString("Music File", "badapple2.chrp");
    m_commandChooser.setDefaultOption("Test", TESTCMD);
    m_commandChooser.addOption("Turn to angle Test", AUTOTURNTESTCMD);
    SmartDashboard.putData("Auto Command", m_commandChooser);
    
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
    buttonIntake.whenHeld(m_intakeCommand);
    buttonPulley.whenHeld(m_pulleyCommand);
    frontButtonTrapdoor.whenHeld(m_frontTrapDoorCommand);
    backButtonTrapdoor.whenHeld(m_backTrapDoorCommand);
    preciseTurnButton1.whenHeld(m_preciseTurnCommand);
    preciseTurnButton1.and(preciseTurnButton2).whenActive(m_resetGyroCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_commandChooser.getSelected();
  }
}

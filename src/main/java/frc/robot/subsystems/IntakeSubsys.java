package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.talonID.*;

public class IntakeSubsys extends SubsystemBase {
  /** Creates a new Intake. */
  private final WPI_TalonSRX intakeTL = new WPI_TalonSRX(INTAKEID);
  public IntakeSubsys() {
    intakeTL.setInverted(true);
  }

  public void rotate(double speed)
  {
    intakeTL.set(speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake temp", intakeTL.getTemperature());
  }
}

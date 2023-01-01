package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.talonID.*;

public class DriveBaseSubsys extends SubsystemBase {
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHTMASTERID);
  private WPI_TalonSRX rightFollow = new WPI_TalonSRX(RIGHTFOLLOWID);
  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFTMASTERID);
  private WPI_TalonSRX leftFollow = new WPI_TalonSRX(LEFTFOLLOWID);
  //private Gyro gyro = new Gyro();

  public DriveBaseSubsys() 
  {
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);
    rightFollow.setInverted(true);
    rightMaster.setInverted(true);
 
    rightFollow.setNeutralMode(NeutralMode.Brake);
    rightMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
  }

  public void drive(double left, double right)
  {
    leftMaster.set(left);
    rightMaster.set(right);
  }
  @Override
  public void periodic() {} //empty
}

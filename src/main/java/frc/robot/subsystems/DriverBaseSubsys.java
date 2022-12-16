package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import edu.wpi.first.wpilibj.interfaces.Gyro;
//import static frc.robot.Constants.*;
import static frc.robot.Constants.talonID.*;
//import static frc.robot.Constants.buttonID.*;

public class DriverBaseSubsys extends SubsystemBase {
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHTMASTERID);
  private WPI_TalonSRX rightFollow = new WPI_TalonSRX(RIGHTFOLLOWID);
  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFTMASTERID);
  private WPI_TalonSRX leftFollow = new WPI_TalonSRX(LEFTFOLLOWID);
  //private Gyro gyro = new Gyro();

  public DriverBaseSubsys() 
  {
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);
    leftFollow.setInverted(true);
    leftMaster.setInverted(true);
 
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
  public boolean isStop()
  {
    return rightMaster.get()==leftMaster.get();
  }
  @Override
  
    // This method will be called once per scheduler run
  public void periodic() 
  {
    
    //double mult = (joystick.getRawAxis(rightTrigger)>0)? normSpeed : fastSpeed;
    //System.out.println(mult);
    //drive(mult*joystick.getRawAxis(yAxisLeft),mult*joystick.getRawAxis(yAxisRight));
  } //empty
}

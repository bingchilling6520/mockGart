package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.talonID.*;

public class TrapDoorSubsys extends SubsystemBase {
  private VictorSPX trapDoor;
  public int id;

  public TrapDoorSubsys(int __id) {
      trapDoor = new VictorSPX(__id);
      id = __id;
  }

  /** Rotate trapdoor with speed
   * @param speed -1.0 to 1.0
  */
  public void rotate(double speed)
  {
    trapDoor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber((id == FRONTTRAPDOORID ? "Front" : "Back") + " trapdoor temp", trapDoor.getTemperature());
  }
}

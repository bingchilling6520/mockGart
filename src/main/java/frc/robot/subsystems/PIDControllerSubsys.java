// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.subsystems.DriverBaseSubsys;
import edu.wpi.first.math.controller.PIDController;
import static frc.robot.Constants.PID.*;

public class PIDControllerSubsys extends SubsystemBase {
  /** Creates a new PIDController. */
  private PIDController controller = new PIDController(KP, KI, KD);
  private PIDControllerSubsys instance = new PIDControllerSubsys();
  public PIDControllerSubsys() {}

  public PIDControllerSubsys getInstance ()
  {
    return instance;
  }
  public void setSetpoint(double x) {
    controller.setSetpoint(x);
  }
  public void reset() {
    controller.reset();
  }
  public void enableContinuousInput(double a, double b) {
    controller.enableContinuousInput(a, b);
  }
  public void setIntegratorRange(double m, double n) {
    controller.setIntegratorRange(m, n);
  }
  public void setTolerance() {
    controller.setTolerance(KTOLERANCE, KTOLERANCEVELOCITY);
  }
  public double calculate(double c) {
    return controller.calculate(c);
  }
  public boolean atSetpoint() {
    return controller.atSetpoint();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run//
  }
}

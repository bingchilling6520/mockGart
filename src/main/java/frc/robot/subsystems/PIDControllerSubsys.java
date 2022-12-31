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
  public PIDControllerSubsys() {}

  public void setSetpoint(double x) {
    controller.setSetpoint(x);
  }
  public void reset() {
    controller.reset();
  }

  /**
   * Enables continuous input.
   *
   * <p>Rather then using the max and min input range as constraints, it considers them to be the
   * same point and automatically calculates the shortest route to the setpoint.
   *
   * @param a The minimum value expected from the input.
   * @param b The maximum value expected from the input.
   */
  public void enableContinuousInput(double a, double b) {
    controller.enableContinuousInput(a, b);
  }

    /**
   * Sets the minimum and maximum values for the integrator.
   *
   * <p>When the cap is reached, the integrator value is added to the controller output rather than
   * the integrator value times the integral gain.
   *
   * @param m The minimum value of the integrator.
   * @param n The maximum value of the integrator.
   */
  public void setIntegratorRange(double m, double n) {
    controller.setIntegratorRange(m, n);
  }

  /**
   * Sets the error which is considered tolerable for use with atSetpoint().
   *
   * KTOLERANCE Position error which is tolerable.
   * KTOLERANCEVELOCITY Velocity error which is tolerable.
   */
  public void setTolerance() {
    controller.setTolerance(KTOLERANCE, KTOLERANCEVELOCITY);
  }
  public double calculate(double c) {
    return controller.calculate(c);
  }
  public boolean isAtSetpoint() {
    return controller.atSetpoint();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run//
  }
}

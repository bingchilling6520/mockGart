// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public final class Algorithm {
      public static double clamp(double val, double min, double max)
      {
            if (val < min)
            {
                  val = min;
            }
            else if(val > max)
            {
                  val = max;
            }
            return val;
      }
      public static double signOf (double val)
      {
            if (val < 0)
            {
                  return -1;
            }
            else if (val > 0)
            {
                  return 1;
            }
            return 0;
            
      }
}

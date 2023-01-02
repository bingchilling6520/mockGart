package frc.robot;

import static frc.robot.Constants.*;

/** Common Maths and other helper function*/
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
      /**Return the sign of the number accounting for sensitivity 
       * @param val the value to get its sign of
       * @return -1 if val is less than -SENSIVITY, 1 if val is greater than SENSIVITY, 0 otherwise
      */
      public static double signOf(double val)
      {
            if (val < -SENSITIVITY)
            {
                  return -1;
            }

            if (val > SENSITIVITY)
            {
                  return 1;
            }

            return 0;
      }

      /**Convert all angle to range -180 to 180 degree
       * @param angle the angle to be converted
       * @return the converted angle between -180 to 180 degree
       */
      public static double simplifyAngle (double angle)
      {
            while (angle > 180)
            {
                  angle -= 360;
            }

            while (angle < -180)
            {
                  angle += 360;
            }

            return angle;
      }
}

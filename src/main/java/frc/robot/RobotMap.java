 package frc.robot;

 /**
  * Map all the ports for the robots
  */
public class RobotMap 
{
    //Drivetrain motors
    //Back Talon on left and right are the leaders, rest are slaves
    public static final int VCTOR_FRONT_LEFT = 13;
    public static final int VICTOR_MIDDLE_LEFT = 14;
    public static final int TALON_BACK_LEFT = 15;
    public static final int VICTOR_FRONT_RIGHT = 2;
    public static final int VICTOR_MIDDLE_RIGHT = 1;
    public static final int TALON_BACK_RIGHT = 0;
    public static final int TALON_ARM = 5;
    public static final int TALON_ARM_SLAVE = 6;


    //Sensors
    public static final int PIGEON = 3;

    public static final int TALON_INTAKE_ROTATION = 42; //placeholder
    public static final int VICTOR_INTAKE_WHEEL = 69; //placeholder
    //Solenoids
    public static final int SOLENOID_TRANSMISSION_HIGH = 0;
    public static final int SOLENOID_TRANSMISSION_LOW = 1;

    public static final int FLYWHEEL_MOTOR_ID = 0;
}

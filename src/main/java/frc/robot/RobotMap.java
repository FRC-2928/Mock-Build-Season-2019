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

    //arm gearbox
   // public static final int TalonArm = ;
    //public static final int TalonArmSlave = ;
  

    //Ground hatch motors
    public static final int TALON_GROUND_HATCH_LEFT = 4;
    public static final int TALON_GROUND_HATCH_RIGHT= 5;

    //Threadbar/intake motors
    public static final int TALON_LEFT_THREADBAR = 10;
    public static final int TALON_RIGHT_THREADBAR = 8;
    public static final int TALON_LEFT_INTAKE = 11;
    public static final int TALON_RIGHT_INTAKE = 9;

    //arm motors are yet to be built. they will be assigned later.

    //Elevator motors
    public static final int SPARK_ELEVATOR = 7;

    //Four-Bar motors
    public static final int TALON_FOUR_BAR = 7;

    //Sensors
    public static final int PIGEON = 3;

    //Solenoids
    public static final int SOLENOID_TRANSMISSION_HIGH = 0;
    public static final int SOLENOID_TRANSMISSION_LOW = 1;
    public static final int SOLENOID_GROUND_HATCH = 6;
    public static final int SOLENOID_INTAKE_DRAWBRIDGE_UP = 4;
    public static final int SOLENOID_INTAKE_DRAWBRIDGE_DOWN = 3;
    public static final int SOLENOID_ELEVATOR_BRAKE_IN= 5;
    public static final int SOLENOID_ELEVATOR_BRAKE_OUT = 2;
}

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Chassis.*;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeArm;
import frc.robot.Subsystem.Shooter.Belts;
import frc.robot.Subsystem.Shooter.Shooter;

//The main robot class, during a match the robot goes through everything in this class

public class Robot extends TimedRobot {
    private Compressor compressor;
    public static Chassis chassis;
    public static Intake intake;
    public static Arm arm;
    public static Shooter shooter;
    public static Belts belts;
    public static OperatorInterface oi;

    
    //public static Sensors sensors;

    @Override
    public void robotInit() {

        compressor = new Compressor();
        compressor.start();
        chassis = new Chassis();
        intake = new Intake();
        arm = new Arm();
        shooter = new Shooter();
        belts = new Belts();
        
        // This has to be at the bottom or things crash
        // OI requires everything to be initialized
        oi = new OperatorInterface(); 
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
        intake.intakearm.resetIntakeEncoder();
    }

    @Override
    public void autonomousPeriodic() { 
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Intake Rotation", intake.intakearm.getIntakePosition());
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
        //chassis.drivetrain.setMotorSafetyEnabled(true);
        
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Shooter Velocity", shooter.getShooterVelocity());
    }

   
    @Override
    public void disabledInit() {
        Scheduler.getInstance().removeAll();

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
}

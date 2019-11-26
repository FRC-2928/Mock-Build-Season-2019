package frc.robot.Subsystem.Inhale;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Intake extends Subsystem {
  WPI_TalonSRX wheelMotor;
  public Intake(){ 
    wheelMotor = new WPI_TalonSRX(RobotMap.TALON_INTAKE_ROTATION);
  }
  
  public void setPower(double power){
    wheelMotor = 
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
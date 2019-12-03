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
    wheelMotor.set(ControlMode.PercentOutput, power);
  }

  public double getIntakePosition(){
    return wheelMotor.getSelectedSensorPosition();
  }

  public void setIntakePosition(double setpoint){
   double kP = 69;
   double kD = 420;
   double fF = 666;
   double Error;
    Error = setpoint - getIntakePosition();
    double P = kP * Error;
    double Input = P + fF;
    setPower(Input);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
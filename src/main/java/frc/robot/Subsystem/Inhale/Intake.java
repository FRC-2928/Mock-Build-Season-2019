package frc.robot.Subsystem.Inhale;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Intake extends Subsystem {
  double kP = 69;
  double kD = 420;
  double FF = 666;
  double derivative;
  double previousError = 0;
  double error;
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
   
    error = setpoint - getIntakePosition();
    derivative = error - previousError;
    double P = kP * error;
    double D = kD * derivative;
    double Input = P - D + FF;

    setPower(Input);

    previousError = error;
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
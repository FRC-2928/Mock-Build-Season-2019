package frc.robot.Subsystem.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Arm extends Subsystem {
  WPI_TalonSRX armMotor;

    //PID Gains
    private double kP = 0.05;
    private double kI = 0;
    private double kD = 0.05;
    private double FF = 0.05;
  
    //PID Terms
    private double integral = 0;
    private double derivative = 0;
    private double previousError = 0;
    
  public Arm(){
    armMotor = new WPI_TalonSRX(RobotMap.TALON_ARM);
    armMotor.configFactoryDefault();

    armMotor.setNeutralMode(NeutralMode.Brake);
    armMotor.configVoltageCompSaturation(12);
    armMotor.enableVoltageCompensation(true);
    armMotor.configPeakCurrentLimit(55);
    armMotor.configPeakCurrentDuration(150);
    armMotor.configContinuousCurrentLimit(45);
    armMotor.configNeutralDeadband(0.01);

    armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  }

  public void setPower(double power){
    armMotor.set(ControlMode.PercentOutput, power);
  }

  public double getArmPosition(){
    return armMotor.getSelectedSensorPosition();
  }

  public void setArmPosition(double reference){
    double error = reference - getArmPosition();
    integral =+ error; 
    derivative = error - previousError;

    double output = (kP * error) + (kI * integral) - (kD * derivative) + FF;
    setPower(output);

    previousError = error;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

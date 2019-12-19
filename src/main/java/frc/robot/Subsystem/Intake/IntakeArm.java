package frc.robot.Subsystem.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotConstants;
import frc.robot.RobotMap;

public class IntakeArm extends Subsystem {
  private WPI_TalonSRX intakeMotor;

  private double error = 0;
  private double proportional = 0;
  private double integral = 0;
  private double derivative = 0;
  private double previousError = 0;
  private double output = 0;

  private double kP = 0;
  private double kI = 0;
  private double kD = 0;
  private double FF = 0;

  public IntakeArm(){
    intakeMotor = new WPI_TalonSRX(RobotMap.TALON_INTAKE_ROTATION);
    intakeMotor.configFactoryDefault();

    intakeMotor.setNeutralMode(NeutralMode.Brake);
    intakeMotor.configVoltageCompSaturation(10);
    intakeMotor.enableVoltageCompensation(true);
    intakeMotor.configNeutralDeadband(0.01);

    intakeMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  }

  public void setIntakePower(double power){
    intakeMotor.set(ControlMode.PercentOutput, power);
  }

  public double getIntakePosition(){
    return intakeMotor.getSelectedSensorPosition()*360/(RobotConstants.INTAKE_ENCODER_TPR * 2);
  }

  public void resetIntakeEncoder(){
    intakeMotor.setSelectedSensorPosition(0);
  }

  public void setIntakePosition(double reference){
    error = reference - getIntakePosition();
    proportional = kP * error;
    integral += error * 0.2;
    derivative = error - previousError;

    output = proportional + integral - derivative + FF;
    setIntakePower(output);

    previousError = error;
  }

  public double getIntakeError(){
    return error;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

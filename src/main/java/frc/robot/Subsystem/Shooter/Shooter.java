package frc.robot.Subsystem.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  //Motor Controllers
  private WPI_TalonSRX shooterMotor;
  private WPI_VictorSPX shooterMotorSlave;

  //PID Gains
  private double kP = 0.05;
  private double kI = 0;
  private double kD = 0.05;
  private double FF = 0.02;

  //PID Terms
  private double error = 0;
  private double integral = 0;
  private double derivative = 0;
  private double previousError = 0;

  public Shooter(){
    shooterMotor = new WPI_TalonSRX(RobotMap.TALON_FLYWHEEL_LEFT);
    shooterMotorSlave = new WPI_VictorSPX(RobotMap.VICTOR_FLYWHEEL_RIGHT);
    shooterMotor.configFactoryDefault();
    shooterMotorSlave.configFactoryDefault();

    shooterMotorSlave.follow(shooterMotor);
    shooterMotorSlave.setInverted(InvertType.OpposeMaster);

    shooterMotor.setNeutralMode(NeutralMode.Brake);
    shooterMotorSlave.setNeutralMode(NeutralMode.Brake);
    shooterMotor.configVoltageCompSaturation(12);
    shooterMotor.enableVoltageCompensation(true);
    shooterMotor.configPeakCurrentLimit(45); //We will probably never hit this but better safe than sorry
    shooterMotor.configPeakCurrentDuration(50);
    shooterMotor.configContinuousCurrentLimit(35); //Same here, we'll most likely be cruising with our feedfoward gain
    shooterMotor.configNeutralDeadband(0.01);

    shooterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
  }

  public void setPower(double power){
    shooterMotor.set(ControlMode.PercentOutput,power);
    shooterMotorSlave.set(ControlMode.PercentOutput, -power);
    SmartDashboard.putNumber("Left Shooter Output", shooterMotor.getMotorOutputVoltage());
    SmartDashboard.putNumber("Right Shooter Output", shooterMotorSlave.getMotorOutputVoltage());
  }

  public double getShooterPosition(){
    return shooterMotor.getSelectedSensorPosition();
  }

  public double getShooterVelocity(){
    return shooterMotor.getSelectedSensorVelocity();
  }

  public void setVelocity(double reference){
    error = reference - getShooterVelocity();
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
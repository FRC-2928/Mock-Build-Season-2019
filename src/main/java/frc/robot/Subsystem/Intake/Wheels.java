package frc.robot.Subsystem.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Wheels extends Subsystem {
  private WPI_VictorSPX wheelMotor;
  public Wheels(){
    wheelMotor = new WPI_VictorSPX(RobotMap.VICTOR_INTAKE_WHEEL);
    wheelMotor.configFactoryDefault();

    wheelMotor.setNeutralMode(NeutralMode.Brake);

    wheelMotor.configVoltageCompSaturation(12);
    wheelMotor.enableVoltageCompensation(true);
    wheelMotor.configNeutralDeadband(0.01);
    wheelMotor.setInverted(InvertType.InvertMotorOutput);
  }

  public void setWheelsPower(double power){
    wheelMotor.set(ControlMode.PercentOutput,power);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

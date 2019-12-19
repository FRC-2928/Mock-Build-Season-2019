package frc.robot.Subsystem.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Belts extends Subsystem {
  WPI_VictorSPX beltMotor;

  public Belts(){
    beltMotor = new WPI_VictorSPX(RobotMap.VICTOR_BELT);
    beltMotor.configFactoryDefault();

    beltMotor.setNeutralMode(NeutralMode.Brake);
    beltMotor.configVoltageCompSaturation(12);
    beltMotor.enableVoltageCompensation(true);
    beltMotor.configNeutralDeadband(0.01);
  }

  public void setPower(double power){
    beltMotor.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

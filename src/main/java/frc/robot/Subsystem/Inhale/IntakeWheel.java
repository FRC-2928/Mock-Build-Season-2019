package frc.robot.Subsystem.Inhale;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Command.SetIntakePower;

/**
 * Add your docs here.
 */

public class IntakeWheel extends Subsystem {
  
  public WPI_VictorSPX IntakeWheelMotor;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public IntakeWheel(){
    IntakeWheelMotor = new WPI_VictorSPX(RobotMap.VICTOR_INTAKE_WHEEL);
  }
  public void setPower(double power){
    IntakeWheelMotor.set(ControlMode.PercentOutput, power);
  }
}

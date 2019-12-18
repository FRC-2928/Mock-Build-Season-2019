package frc.robot.Subsystem.Intake;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class IntakeArm extends Subsystem {
  private WPI_TalonSRX intakeMotor;
  public IntakeArm(){
    intakeMotor = new WPI_TalonSRX(RobotMap.TALON_INTAKE_ROTATION);
    intakeMotor.configFactoryDefault();

    intakeMotor.setNeutralMode(NeutralMode.Brake);
    intakeMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

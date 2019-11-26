/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class armBOI extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double kP;
  private double kI;
  private double kD;
  private double derivative;
  private double errorSum;
  private double previousError;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void MoveArmDown() {

  }
  public void MoveArmUp() {

  }
  
  public void setArmPower(double power) {
    armMotor.set(power);
    
  }

  public double getArmPos() {
    double ArmPosition = .getPosition();
    return ArmPosition;
    // bro we gonna put in the encoder position once we have it
  }

  public void setArmPos() {

    errorSum = 0;
    derivative = 0;
    if (Math.abs(error) < ) {
      errorSum += (error * );

    }
    // bro we gotta fill in these errors once we have actual values
    else{
      errorSum = 0;

    }
    
    derivative = (error - previousError);

    if (error < 0){
     kP = ;
     kI = ;
     kD = ;
    }
    if (error > 0){
      kP = ;
      kI = ;
      kD = ;
      }


    // bro we gotta fill in these errors once we have actual values

      armMovement == (kP * error) + (kI * errorSum) + (kD * derivative);

  }

  public void armMotor() {
    armMotor = new CANSparkMax(RobotMap.TalonArm, MotorType.kBrushless);
    armMotorSlave = new CANSparkMax(RobotMap.TalonArmSlave, MotorType.kBrushless);
    armMotorSlave.follow(armMotor);

  }


  public void resetEncoderPosition() {
  ArmEncoder.setPosition(0);
  }
  public double GetEncoderPostion() {
double ArmPosition = ArmEncoder.GetEncoderPostion();
return ArmPosition;
ArmEncoder = new CANsparkmax(RobotMap.TalonArm);
  }

}

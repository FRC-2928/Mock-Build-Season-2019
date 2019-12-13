/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystem.arm;

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
public class ArmBOI extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double kP =0;
  private double kI =0;
  private double kD =0;
  private double derivative;
  private double errorSum;
  private double previousError;
  private CANSparkMax armMotor;
  private CANSparkMax armMotorSlave;
  private CANEncoder armEncoder;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
 
  public void setArmPower(double power) {
    armMotor.set(power);
    
  }

  public double getArmPos() {
    double ArmPosition = armEncoder.getPosition();
    return ArmPosition;
    // bro we gonna put in the encoder position once we have it
  }

  public void setArmPos() {

  }

  public void ArmBOI() {
    armMotor = new CANSparkMax(RobotMap.TALON_ARM, MotorType.kBrushless);
    armMotorSlave = new CANSparkMax(RobotMap.TALON_ARM_SLAVE, MotorType.kBrushless);
    armMotorSlave.follow(armMotor);
    armEncoder = new CANEncoder(armMotor);
    //set arm encoder value when we have it.

  }


  public void resetEncoderPosition() {
    armEncoder.setPosition(0);
  }
  public double GetEncoderPostion() {
    double ArmPosition = armEncoder.getPosition();
    // ArmEncoder = new CANsparkmax(RobotMap.TalonArm);
    return ArmPosition;
  }

}

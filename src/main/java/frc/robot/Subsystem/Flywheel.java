/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Flywheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX flyWheelMotor;
  public Flywheel(){
    flyWheelMotor = new WPI_TalonSRX(RobotMap.FLYWHEEL_MOTOR_ID);

  }
public void setFlyWheelSpeed(double power){
  flyWheelMotor.set(ControlMode.PercentOutput, power);
} 
public int getflywheelencoder(){
  return flyWheelMotor.getSelectedSensorPosition();
}
 @Override
  public void initDefaultCommand() {
  }


}

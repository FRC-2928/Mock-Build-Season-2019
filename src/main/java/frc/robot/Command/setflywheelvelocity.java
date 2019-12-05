/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Command;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



public class setflywheelvelocity extends Command {
  private int desiredVelocity;
  private int velocity;
  private double derivative;
  private double error;
  private double previousError;
  private double kP;
  private double kD;
  private double kI;
  private double min_command;
  private double power;
  private double errorSum;
  public setflywheelvelocity() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //int velocity;
    velocity = Robot.flywheel.getflywheelvelocity();
    error = velocity - desiredVelocity;

  
  derivative = (error - previousError);

  if (error > 0){
    kP = 0.074;
    kI = 0.07;
    kD = 0.275;
    min_command = 0.006;
    ff = 0;
  
  }
  if (Math.abs(error) < 4) {
      power = (kP * error) + (kI * errorSum) - (kD *derivative) + ff;
  }
  Robot.flywheel.setFlyWheelSpeed(power);
}
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (desiredVelocity == velocity){
      return true;
    }
      else return false;
    }
  //Maybe it should stop when you take your hand off

  // Called once after isFinished returns true
  @Override
  protected void end(){} 
    

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

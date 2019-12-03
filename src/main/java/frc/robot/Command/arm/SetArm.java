/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Command;

import java.awt.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command {
  public MoveArm(double power) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(robot.armBoi.setArmPower);
    this.power = power;

  }

  public enum LiftState {
    PICK_UP, FIRE_BALL
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {



    switch (setpoint) {
      case PICK_UP:
        setpoint = ;
      break;

      case FIRE_BALL:
        setpoint = ;
      break;


     // case 
     //M might need another position


     
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

      armMovement = (kP * error) + (kI * errorSum) + (kD * derivative);
      setArmPower(armMovement);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double power;
    
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

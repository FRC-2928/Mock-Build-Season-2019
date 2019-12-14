/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Command.arm;

import java.awt.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetArm extends Command {
  private double power;
  private double errorSum;
  private double derivative;
  private double error;
  private double previousError;
  private double kP;
  private double kI;
  private double kD;
  private double output;
  private double ff;




  private double setpointInches;

  public enum LiftState {
    PICK_UP, FIRE_BALL
  }
  private LiftState setpoint;

  public SetArm(double power) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(frc.robot.Robot.armBOI);
    this.power = power;

  }



  // Called just before this Command runs the first time
  @Override
  protected void initialize() {


// ???????
    switch (setpoint) {
      case PICK_UP:
        setpointInches = 10 ;
      break;

      case FIRE_BALL:
        setpointInches = 20;
      break;

    }
     // case 
     //M might need another position


  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double power;
    

     
    errorSum = 0;
    derivative = 0;
    if (Math.abs(error) < 0) {
      errorSum += (error * 1);

    }
    // bro we gotta fill in these errors once we have actual values
    else{
      errorSum = 0;

    }
    
    derivative = (error - previousError);

    if (error < 0){
     kP = 0;
     kI = 0;
     kD = 0;
    }
    if (error > 0){
      kP = 0;
      kI = 0;
      kD = 0;
      }
      //IM TYPING ON THE KEYBOARD. 
      //<------ THESE ARE COMMENT SLASHES
      //CONNALLY WAS HERE
      //connarly was not here
      
   
    // bro we gotta fill in these errors once we have actual values

      output = ff + (kP * error) + (kI * errorSum) - (kD * derivative);
      frc.robot.Robot.armBOI.setArmPower(output);
      //Robot.armBOI.setArmPower(output);
    }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double ArmPosition = frc.robot.Robot.armBOI.getArmPos();

    //put in values for when its aproching dangerous area

    if (setpointInches == ArmPosition){
      return true;
    }
      else return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    power = 0;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}

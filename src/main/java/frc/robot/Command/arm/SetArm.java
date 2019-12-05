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
      //IM TYPING ON THE KEYBOARD. 
      //<------ THESE ARE COMMENT SLASHES
      //CONNALLY WAS HERE
      
      /*
      Last Christmas, I gave you my heart
But the very next day you gave it away
This year, to save me from tears
I'll give it to someone special
Last Christmas, I gave you my heart
But the very next day you gave it away
This year, to save me from tears
I'll give it to someone special
Once bitten and twice shy
I keep my distance
But you still catch my eye
Tell me, baby
Do you recognize me?
Well, it's been a year
It doesn't surprise me
(Merry Christmas!) I wrapped it up and sent it
With a note saying, "I love you, " I meant it
Now, I know what a fool I've been
But if you kissed me now
I know you'd fool me again
      */  
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

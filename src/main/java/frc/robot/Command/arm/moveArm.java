/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Command;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command {
  public MoveArm(double power) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(robot.armBoi.setArmPower);
    this.power = power;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // we want this to move up and down to find it's zero area.
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

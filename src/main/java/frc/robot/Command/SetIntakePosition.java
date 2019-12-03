package frc.robot.Command;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetIntakePosition extends Command {
  double setpoint;
  public SetIntakePosition(double setpoint) {
    requires(Robot.intake);
    this.setpoint = setpoint;
  }

  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.intake.setIntakePosition(setpoint);
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

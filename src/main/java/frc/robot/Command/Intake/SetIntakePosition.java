package frc.robot.Command.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetIntakePosition extends Command {
  private double reference;

  private double errorTolerance;

  public SetIntakePosition(double reference) {
    requires(Robot.intake.intakearm);
    this.reference = reference;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.intake.intakearm.setIntakePosition(reference);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  private boolean inZone(){
    if(Math.abs(Robot.intake.intakearm.getIntakeError()) < 0.5){
      return true;
    }
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

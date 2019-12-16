package frc.robot.Command.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetShooterPower extends Command {
  private double power;
  public SetShooterPower(double power) {
    requires(Robot.shooter);
    this.power = power;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.shooter.setPower(power);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.shooter.setPower(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}

package frc.robot.Command;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystem.Flywheel;

public class ShootFlywheel extends Command {
  Flywheel ourFlywheel;
  private double power;
  
  public ShootFlywheel(double power) {
    this.power = power;
    ourFlywheel = new Flywheel();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    ourFlywheel.setFlyWheelSpeed(power);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    ourFlywheel.setFlyWheelSpeed(0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}

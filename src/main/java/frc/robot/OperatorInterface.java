package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.Command.Arm.SetArmPower;
import frc.robot.Command.Chassis.Shift;
import frc.robot.Command.Intake.SetIntakePower;
import frc.robot.Command.Intake.SetWheelPower;
import frc.robot.Command.Shooter.SetBeltPower;
import frc.robot.Command.Shooter.SetShooterPower;
import frc.robot.Subsystem.Chassis.*;

public class OperatorInterface {

    // Driving
    private static final XboxController driveStick = new XboxController(0);

    private static final JoystickButton gearButtonLow = new JoystickButton(driveStick, 9);
    private static final JoystickButton gearButtonHigh = new JoystickButton(driveStick, 10);

    private static final JoystickButton intakeButton = new JoystickButton(driveStick, 5);
    private static final JoystickButton outtakeButton = new JoystickButton(driveStick, 6);

    private static final JoystickButton armUpButton = new JoystickButton(driveStick, 1);
    private static final JoystickButton armDownButton = new JoystickButton(driveStick, 2);

    private static final JoystickButton shooterButton = new JoystickButton(driveStick, 3);

    private static final JoystickButton intakeUp = new JoystickButton(driveStick, 8);
    private static final JoystickButton intakeDown = new JoystickButton(driveStick, 7);


    OperatorInterface() {
        gearButtonLow.whenPressed(new Shift(Transmission.GearState.LOW));
        gearButtonHigh.whenPressed(new Shift(Transmission.GearState.HIGH));

        intakeButton.whileHeld(new SetWheelPower(0.8));
        outtakeButton.whileHeld(new SetWheelPower(-0.6));

        armUpButton.whileHeld(new SetArmPower(0.7));
        armDownButton.whileHeld(new SetArmPower(-0.7));

        shooterButton.whileHeld(new SetShooterPower(0.9));
        shooterButton.whileHeld(new SetBeltPower(0.9));

        intakeUp.whileHeld(new SetIntakePower(0.75));
        intakeDown.whileHeld(new SetIntakePower(-0.75));
    }

    public double getDriveY() {
        return driveStick.getY();
    }

    public double getDriveYL(){
        return driveStick.getY(Hand.kLeft);
    }

    public double getDriveX() {
        return driveStick.getX();
    }

    public double getDriveXR(){
        return driveStick.getX(Hand.kRight);
    }

    public double getLeftTrigger(){
        return driveStick.getTriggerAxis(Hand.kLeft);
    }

    public double getRightTrigger(){
        return driveStick.getTriggerAxis(Hand.kRight);
    }

    public double getPOV(){
        return driveStick.getPOV();
    }
   
    public void setRumble(double rumble){
        driveStick.setRumble(RumbleType.kLeftRumble, rumble);
        driveStick.setRumble(RumbleType.kRightRumble, rumble);
    }

}

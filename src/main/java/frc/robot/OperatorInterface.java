package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Command.SetIntakePosition;
import frc.robot.Command.ShootFlywheel;
import frc.robot.Command.Chassis.Shift;
import frc.robot.Command.arm.setArmPower;
import frc.robot.Subsystem.Chassis.*;
import frc.robot.Subsystem.arm.ArmBOI;
import frc.robot.Command.Chassis.SetIntakeWheel;

public class OperatorInterface {

    // Driving
    private static final XboxController driveStick = new XboxController(0);
    private static final Joystick driveController = new Joystick(1);

    private static final JoystickButton gearButtonLow = new JoystickButton(driveStick, 9);
    private static final JoystickButton gearButtonHigh = new JoystickButton(driveStick, 10);

    private static final JoystickButton gearButtonLowController = new JoystickButton(driveController, 7);
    private static final JoystickButton gearButtonHighController = new JoystickButton(driveController, 8);

    private static final JoystickButton intakeButton = new JoystickButton(driveStick, 7);

    private static final JoystickButton intakeWheelButton = new JoystickButton(driveStick, 0);
    private static final JoystickButton shooterStart = new JoystickButton(driveController, 1);
    private static final JoystickButton shooterStop = new JoystickButton(driveController, 3);
    private static final JoystickButton armPowerButton = new JoystickButton(driveController, 4); //placeholder button


    OperatorInterface() {
        gearButtonLow.whenPressed(new Shift(Transmission.GearState.LOW));
        gearButtonHigh.whenPressed(new Shift(Transmission.GearState.HIGH));

        gearButtonLowController.whenPressed(new Shift(Transmission.GearState.LOW));
        gearButtonHighController.whenPressed(new Shift(Transmission.GearState.HIGH));

        intakeButton.whileHeld(new SetIntakePosition(420)); //placeholder
        intakeButton.whenReleased(new SetIntakePosition(0));

        intakeWheelButton.whileHeld(new SetIntakeWheel(0.1));
        intakeWheelButton.whileHeld(new SetIntakeWheel(0));
        shooterStart.whenPressed(new ShootFlywheel(0.6));
        armPowerButton.whenPressed(new setArmPower(1)); //placeholder value bro
    }

    public double getDriveY() {
        return driveStick.getY();
    }

    public double getDriveX() {
        return driveStick.getX();
    }

    public double getControllerY(){
        return driveController.getY();
    }

    public double getControllerX(){
        return driveController.getX();
    }

    public double getControllerZ(){
        return driveController.getZ();
    }

}

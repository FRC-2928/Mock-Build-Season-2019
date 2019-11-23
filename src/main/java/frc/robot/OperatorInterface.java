package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Command.ShootFlywheel;
import frc.robot.Command.Chassis.Shift;
import frc.robot.Subsystem.Chassis.*;

public class OperatorInterface {

    // Driving
    private static final Joystick driveStick = new Joystick(0);
    private static final Joystick driveController = new Joystick(1);

    private static final JoystickButton gearButtonLow = new JoystickButton(driveStick, 9);
    private static final JoystickButton gearButtonHigh = new JoystickButton(driveStick, 10);

    private static final JoystickButton gearButtonLowController = new JoystickButton(driveController, 7);
    private static final JoystickButton gearButtonHighController = new JoystickButton(driveController, 8);

    private static final JoystickButton shooterStart = new JoystickButton(driveController, 1);
    private static final JoystickButton shooterStop = new JoystickButton(driveController, 3);


    OperatorInterface() {
        gearButtonLow.whenPressed(new Shift(Transmission.GearState.LOW));
        gearButtonHigh.whenPressed(new Shift(Transmission.GearState.HIGH));

        gearButtonLowController.whenPressed(new Shift(Transmission.GearState.LOW));
        gearButtonHighController.whenPressed(new Shift(Transmission.GearState.HIGH));

        shooterStart.whenPressed(new ShootFlywheel(0.6));
    }

    public double getDriveY() {
        return driveStick.getY();
    }

    public double getDriveX() {
        return driveStick.getX();
    }

    public double getDriveZ() {
        return driveStick.getZ();
    }

    public double getSlider(){
        return driveStick.getThrottle();
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

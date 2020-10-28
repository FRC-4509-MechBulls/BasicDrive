package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DirectDriveCommand;
// import frc.robot.commands.SetEncoderCommand;
// import frc.robot.commands.TurnoffEncoderCommand;

import frc.robot.subsystems.DrivingSubsystem;
// import frc.robot.subsystems.EncoderSubsystem;

public class RobotContainer {

  // XboxController controller2 = new XboxController(Constants.XBOX_CONTROLLER_2_PORT);
  // XboxController controller1 = new XboxController(Constants.XBOX_CONTROLLER_1_PORT);  
  Joystick rightJoystick = new Joystick(0);
  Joystick leftJoystick = new Joystick(1);

  DrivingSubsystem drivingSubsystem = new DrivingSubsystem();

  // EncoderSubsystem encoderSubsystem = new EncoderSubsystem();
  public RobotContainer() {
    configureButtonBindings();

    drivingSubsystem.setDefaultCommand(new DirectDriveCommand(drivingSubsystem, () -> getRight(), () -> getLeft()));

  }

  public double getRight() {
    // controller1.getX(GenericHID.Hand.kLeft); For Xboxcontrollers
    return rightJoystick.getY();
  }

  public double getLeft() {
    // double n = controller1.getTriggerAxis(GenericHID.Hand.kRight) - controller1.getTriggerAxis(GenericHID.Hand.kLeft); For Xboxccontrollers
    // return n; For Xboxcontrollers
    return leftJoystick.getY();
}



  private void configureButtonBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  // // An ExampleCommand will run in autonomous
  // // return m_autoCommand;
  // }
}
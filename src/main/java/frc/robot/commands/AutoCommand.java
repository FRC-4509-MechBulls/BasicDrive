package frc.robot.commands;

import java.util.function.DoubleSupplier;

import frc.robot.Robot;
import frc.robot.subsystems.DrivingSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoCommand extends CommandBase {

	private DrivingSubsystem drivingSubsystem;
    Timer timer;
	public AutoCommand(DrivingSubsystem subsystem) {
		// Use addRequirements() here to declare subsystem dependencies.
        drivingSubsystem = subsystem;
        timer = new Timer();
		addRequirements(drivingSubsystem);
	}

	public void initialize() {
		// Make sure the controller is initialized before we try to use it.
        timer.reset();
        timer.start();
	}

	@Override
	public void execute() {
	 if (timer.get() < 10) {
        drivingSubsystem.drive.arcadeDrive(.5, 0);// drive straight at half speed, 
                                                   //this is using arcade drive as an example but you can use the drive method in the subsystem as well
     }
	}

	public boolean isFinished() {
		return timer.get() > 14; // end the command if we have run for at least 14 seconds
	}

}
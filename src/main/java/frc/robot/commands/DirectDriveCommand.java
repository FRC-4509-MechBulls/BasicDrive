package frc.robot.commands;

import java.util.function.DoubleSupplier;

import frc.robot.Robot;
import frc.robot.subsystems.DrivingSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DirectDriveCommand extends CommandBase {

	private final DrivingSubsystem drivingSubsystem;
	private final DoubleSupplier left;
	private final DoubleSupplier right;

	public DirectDriveCommand(DrivingSubsystem subsystem, DoubleSupplier l, DoubleSupplier r) {
		// Use addRequirements() here to declare subsystem dependencies.
		drivingSubsystem = subsystem;
		left = l;
		right = r;
		addRequirements(drivingSubsystem);
	}

	public void initialize() {
		// Make sure the controller is initialized before we try to use it.

	}

	@Override
	public void execute() {
		drivingSubsystem.drive(left.getAsDouble(), right.getAsDouble()); // Use input directly from the controller
	}

	public boolean isFinished() {
		return false; // We don't want the command to stop, we want it to be interrupted.
	}

	protected void end() {
		drivingSubsystem.stop();
	}

}
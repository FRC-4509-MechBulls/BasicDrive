package frc.robot.commands;

import java.util.function.DoubleSupplier;

import frc.robot.Robot;
import frc.robot.subsystems.DrivingSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DirectDriveCommand extends CommandBase {

	private final DrivingSubsystem dSub;

	private final DoubleSupplier left;
	private final DoubleSupplier right;

	public DirectDriveCommand(DrivingSubsystem subsystem, DoubleSupplier l, DoubleSupplier r) {
		// Use addRequirements() here to declare subsystem dependencies.
		dSub = subsystem;
		left = l;
		right = r;
		addRequirements(dSub);
	}

	public void initialize() {
		// Make sure the controller is initialized before we try to use it.

	}

	@Override
	public void execute() {
		dSub.drive(left.getAsDouble(), right.getAsDouble()); // Use input directly from the controller
	}

	public boolean isFinished() {
		return false; // We don't want the command to stop, we want it to be interrupted.
	}

	protected void end() {
		dSub.stop();
	}

}
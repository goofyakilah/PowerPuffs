package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "LinearSlideControl", group = "TeleOp")
public class LinearSlideControl extends LinearOpMode {

    private DcMotor linearSlideMotor;

    @Override
    public void runOpMode() {
        linearSlideMotor = hardwareMap.get(DcMotor.class, "linear_slide_motor");

        waitForStart();

        while (opModeIsActive()) {
            double linearSlidePower = gamepad1.left_stick_y;

            // Control the continuous movement of the linear slide using the left stick Y
            linearSlideMotor.setPower(linearSlidePower);

            // Control the different heights using buttons A, Y, B, X
            if (gamepad1.a) {
                // Move to the A height position
                // Adjust motor power and target position accordingly
                linearSlideMotor.setPower(0.5);
                // Set the target position for the A height
                linearSlideMotor.setTargetPosition(/* A height position */);
                // Use motor run to position mode
                linearSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else if (gamepad1.y) {
                // Move to the Y height position
                // Adjust motor power and target position accordingly
                linearSlideMotor.setPower(0.5);
                // Set the target position for the Y height
                linearSlideMotor.setTargetPosition(/* Y height position */);
                // Use motor run to position mode
                linearSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else if (gamepad1.b) {
                // Move to the B height position
                // Adjust motor power and target position accordingly
                linearSlideMotor.setPower(0.5);
                // Set the target position for the B height
                linearSlideMotor.setTargetPosition(/* B height position */);
                // Use motor run to position mode
                linearSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else if (gamepad1.x) {
                // Move to the X height position
                // Adjust motor power and target position accordingly
                linearSlideMotor.setPower(0.5);
                // Set the target position for the X height
                linearSlideMotor.setTargetPosition(/* X height position */);
                // Use motor run to position mode
                linearSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else {
                // Stop the motor if no buttons are pressed
                linearSlideMotor.setPower(0);
            }

            // Update telemetry or other necessary operations
            telemetry.update();
        }
    }
}

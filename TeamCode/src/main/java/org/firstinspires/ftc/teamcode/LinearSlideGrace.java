package org.firstinspires.ftc.teamcode;

public class LinearSlideGrace {package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

    @Autonomous(name="linearSlide", group="auto")
//@Disabled

    public class linearSlide extends LinearOpMode {

        /* Declare OpMode members. */
        private ElapsedTime     runtime = new ElapsedTime();
        DcMotor motorFL = null;
        DcMotor motorFR = null;
        DcMotor motorBL = null;
        DcMotor motorBR = null;
        DcMotor linearSlide;
        DcMotor linearRetract;
        Servo servoMarker;

        static final double     FORWARD_SPEED = 0.4;
        static final double     FORWARD_SPEED2 = 0.05;
        static final double     STOP_SPEED = 0;

        @Override
        public void runOpMode() {

            /*
             * Initialize the drive system variables.
             * The init() method of the hardware class does all the work here
             */
            linearSlide = hardwareMap.dcMotor.get("linearSlide");
            linearRetract = hardwareMap.dcMotor.get("linearRetract");

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Ready to run");    //
            telemetry.update();

            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            //extend the arm
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 2.7)) {
                linearSlide.setPower(FORWARD_SPEED);
                linearRetract.setPower(FORWARD_SPEED);
                telemetry.addData("Path", "Linear 1: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
            }

            while (opModeIsActive() && (runtime.seconds() < 2.0)) {
                linearSlide.setPower(STOP_SPEED);
                linearRetract.setPower(STOP_SPEED);
                telemetry.addData("Motor", "Stopped");    //
                telemetry.update();
            }


        }
    }
}

    public void extendVerticalSlides(int verticalSlideExtendPos) {
        verticalLeftSlide.setTarget(verticalSlideExtendPos); // the position you want the slides to reach
        verticalLeftSlide.retMotorEx().setTargetPositionTolerance(1); // set accuracy to 1 tick
        verticalLeftSlide.toPosition();
        verticalLeftSlide.setPower(1); // raise at some power

        verticalRightSlide.setTarget(verticalSlideExtendPos);
        verticalRightSlide.retMotorEx().setTargetPositionTolerance(1);
        verticalRightSlide.toPosition();
        verticalRightSlide.setPower(1);
    }
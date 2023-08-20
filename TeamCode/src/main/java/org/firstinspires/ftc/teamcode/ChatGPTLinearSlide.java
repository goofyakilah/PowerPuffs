package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ChatGPTLinearSlide extends LinearOpMode {

    DcMotor LiftMotorL;
    DcMotor LiftMotorR;

    @Override
    public void runOpMode() {
        LiftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        LiftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

        int positionL = LiftMotorL.getCurrentPosition();
        int positionR = LiftMotorR.getCurrentPosition();

        LiftMotorR.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        LiftMotorL.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        LiftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LiftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LiftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        @Override
        public void loop() {
            double linearSlidePower = gamepad1.left_stick_y;

            LiftMotorR.setPower(linearSlidePower);
            LiftMotorL.setPower(linearSlidePower);


            if (gamepad1.a) {
                LiftMotorR.setPower(0.2);
                LiftMotorR.setTargetPosition(0);
                LiftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LiftMotorL.setPower(0.2);
                LiftMotorL.setTargetPosition(0);
                LiftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else if (gamepad1.y) {
                LiftMotorR.setPower(0.2);
                LiftMotorR.setTargetPosition(500);
                LiftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LiftMotorL.setPower(0.2);
                LiftMotorL.setTargetPosition(500);
                LiftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else if (gamepad1.b) {
                LiftMotorR.setPower(0.2);
                LiftMotorR.setTargetPosition(700);
                LiftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LiftMotorL.setPower(0.2);
                LiftMotorL.setTargetPosition(700);
                LiftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else if (gamepad1.x) {
                LiftMotorR.setPower(0.2);
                LiftMotorR.setTargetPosition(1000);
                LiftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LiftMotorL.setPower(0.2);
                LiftMotorL.setTargetPosition(1000);
                LiftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else {
                LiftMotorR.setPower(0);
                LiftMotorL.setPower(0);
                LiftMotorL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                LiftMotorR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }

            telemetry.update();}
        }
    }
}

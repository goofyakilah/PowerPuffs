package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ChatGPTLinearSlide extends OpMode {

    DcMotor LiftMotorL;
    DcMotor LiftMotorR;

    boolean move = false;

    private static final int PositionA = 0;
    private static final int PositionY = 1500;
    private static final int PositionB = 1700;
    private static final int PositionX = 2000;

    public float speedLimiter = 0.5f;



    @Override
    public void init () {
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
            if (gamepad1.a && !move) {
                targetPosition(PositionA);
                move = true;

            } else if (gamepad1.y && !move) {
                targetPosition(PositionY);
//                move = true;

            } else if (gamepad1.b && !move) {
                targetPosition(PositionB);
 //               move = true;

            } else if (gamepad1.x && !move) {
                targetPosition(PositionX);
//                move = true;

            } else {
                LiftArmHigh();
            }

            telemetry.update();}


    private void targetPosition(int position) {
        LiftMotorR.setPower(0.9);
        LiftMotorR.setTargetPosition(position);
        LiftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LiftMotorL.setPower(0.9);
        LiftMotorL.setTargetPosition(position);
        LiftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (LiftMotorL.isBusy() && LiftMotorR.isBusy() && move){}
        LiftMotorR.setPower(0);
        LiftMotorL.setPower(0);
        LiftMotorL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LiftMotorR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        move = false;
    }

    public void LiftArmHigh(){
        double y = -gamepad1.left_stick_y;
        LiftMotorL.setPower(speedLimiter * y);
        LiftMotorR.setPower(speedLimiter * y);


    }
 }


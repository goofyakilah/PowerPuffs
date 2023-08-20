package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinearSlideGrace extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;



    boolean move = false;


    public float speedLimiter = 0.5f;


    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

        int positionL = liftMotorL.getCurrentPosition();
        int positionR = liftMotorR.getCurrentPosition();

        liftMotorR.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        liftMotorL.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        liftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {
            if (gamepad1.a && !move) {
                int setTargetPosition = 1500;
                liftMotorL.setTargetPosition(setTargetPosition);
                liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setTargetPosition(setTargetPosition);
                liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setPower(0.2);
                liftMotorL.setPower(0.2);
                move = true;
        }  else if (gamepad1.b && !move) {
                int setTargetPosition = 1200;
                liftMotorL.setTargetPosition(setTargetPosition);
                liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setTargetPosition(setTargetPosition);
                liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setPower(0.2);
                liftMotorL.setPower(0.2);
                move = true;
        }   else if (gamepad1.y && !move) {
                int setTargetPosition= 2000;
                liftMotorL.setTargetPosition(setTargetPosition);
                liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setTargetPosition(setTargetPosition);
                liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setPower(0.2);
                liftMotorL.setPower(0.2);
                move = true;
        }   else if (gamepad1.x && !move) {
                int setTargetPosition = 0;
                liftMotorL.setTargetPosition(setTargetPosition);
                liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setTargetPosition(setTargetPosition);
                liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorR.setPower(0.2);
                liftMotorL.setPower(0.2);
                move = true;
        }   else if (move &&!liftMotorR.isBusy() &&!liftMotorL.isBusy()){
                liftMotorL.setPower(0);
                liftMotorR.setPower(0);
                move=false;
        }   else {
            liftArmHigh();
        }

    }


    public void liftArmHigh(){
        double y = - gamepad1.left_stick_y;
        liftMotorL.setPower(speedLimiter * y);
        liftMotorR.setPower(speedLimiter * y);

    }

}

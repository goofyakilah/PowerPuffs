package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LiftAlan extends OpMode {

    DcMotor liftMotorL;
    DcMotor liftMotorR;

    int targetPosition;
    boolean isMoving = false;

    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

        liftMotorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);

        liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
    @Override
    public void loop(){
        if(gamepad1.a) {
            liftMotorL.setTargetPosition(0);
            liftMotorR.setTargetPosition(0);
            liftMotorL.setPower(0.5);
            liftMotorR.setPower(0.5);
        } else if (gamepad1.x) {
            liftMotorL.setTargetPosition(500);
            liftMotorR.setTargetPosition(500);
            liftMotorL.setPower(0.5);
            liftMotorR.setPower(0.5);
        } else if (gamepad1.b){
            liftMotorL.setTargetPosition(1000);
            liftMotorR.setTargetPosition(1000);
            liftMotorL.setPower(0.5);
            liftMotorR.setPower(0.5);
        } else if (gamepad1.y) {
            liftMotorL.setTargetPosition(1500);
            liftMotorR.setTargetPosition(1500);
            liftMotorL.setPower(0.5);
            liftMotorR.setPower(0.5);
        }



    }
}

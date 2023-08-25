package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Lifttelemetry extends OpMode {

    DcMotor liftMotorL;
    DcMotor liftMotorR;

    int targetPositionRight;
    int targetPositionLeft;
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
//        liftMotorL.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    @Override
    public void loop(){
        if(gamepad1.a && !isMoving) {
            targetPositionRight = 1000;
            targetPositionLeft = 1000;
            liftMotorL.setTargetPosition(targetPositionLeft);
            liftMotorR.setTargetPosition(targetPositionRight);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setPower(0.2);
            liftMotorL.setPower(-0.2);
            isMoving = true;
        }

        if(isMoving && !liftMotorL.isBusy() && !liftMotorR.isBusy()) {
            liftMotorL.setPower(0);
            liftMotorR.setPower(0);
            isMoving = false;
        }

        telemetry.addData("LEFT", liftMotorL.getCurrentPosition());
        telemetry.addData("RIGHT", liftMotorR.getCurrentPosition());
        telemetry.update();
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinerSlideAkilah extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;

    public boolean move = false;


    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");
        int positionL = liftMotorL.getCurrentPosition();
        int positionR = liftMotorR.getCurrentPosition();

        liftMotorR.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        liftMotorL.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        liftMotorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {
        if (gamepad1.a && !move) {
            int targetposition = 500;
            liftMotorL.setTargetPosition(targetposition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setTargetPosition(targetposition);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setPower(0.2);
            liftMotorL.setPower(0.2);
            move = true;
        }

        if (move && !liftMotorL.isBusy() && !liftMotorR.isBusy()) {
            liftMotorR.setPower(0);
            liftMotorL.setPower(0);
            move = false;
        }

        if (gamepad1.b && !move) {
            int targetposition = 1000;
            liftMotorL.setTargetPosition(targetposition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setTargetPosition(targetposition);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setPower(0.2);
            liftMotorL.setPower(0.2);
            move = true;
        }

        if (move && !liftMotorL.isBusy() && !liftMotorR.isBusy()) {
            liftMotorR.setPower(0);
            liftMotorL.setPower(0);
            move = false;
        }

        if (gamepad1.x && !move) {
            int targetposition = 1500;
            liftMotorL.setTargetPosition(targetposition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setTargetPosition(targetposition);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setPower(0.2);
            liftMotorL.setPower(0.2);
            move = true;
        }

        if (move && !liftMotorL.isBusy() && !liftMotorR.isBusy()) {
            liftMotorR.setPower(0);
            liftMotorL.setPower(0);
            move = false;
        }

        if (gamepad1.y && !move) {
            int targetposition = 2000;
            liftMotorL.setTargetPosition(targetposition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setTargetPosition(targetposition);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setPower(0.2);
            liftMotorL.setPower(0.2);
            move = true;
        }

        if (move && !liftMotorL.isBusy() && !liftMotorR.isBusy()) {
            liftMotorR.setPower(0);
            liftMotorL.setPower(0);
            move = false;
        }


    }}
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinearSlideCarolina extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;

    double speed = 0.2;
    public boolean isMoving = false;

    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

        int positionL = liftMotorL.getCurrentPosition();
        int positionR = liftMotorR.getCurrentPosition();

        liftMotorR.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        liftMotorL.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        liftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        if (gamepad1.a && !isMoving) {
            isMoving = true;
            int targetPosition = 500;
            liftMotorR.setTargetPosition(targetPosition);
            liftMotorL.setTargetPosition(targetPosition);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setPower(speed);
            liftMotorR.setPower(speed);

        }
        else if (gamepad1.b && !isMoving) {
            isMoving = true;
            int targetPosition = 1000;
            liftMotorR.setTargetPosition(targetPosition);
            liftMotorL.setTargetPosition(targetPosition);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setPower(speed);
            liftMotorR.setPower(speed);
        }
        else if (gamepad1.x && !isMoving) {
            isMoving = true;
            int targetPosition = 1500;
            liftMotorR.setTargetPosition(targetPosition);
            liftMotorL.setTargetPosition(targetPosition);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setPower(speed);
            liftMotorR.setPower(speed);
        }
            else if (gamepad1.y && !isMoving) {
                isMoving = true;
                int targetPosition = 2000;
                liftMotorR.setTargetPosition(targetPosition);
                liftMotorL.setTargetPosition(targetPosition);
                liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftMotorL.setPower(speed);
                liftMotorR.setPower(speed);
            }
        }
    }
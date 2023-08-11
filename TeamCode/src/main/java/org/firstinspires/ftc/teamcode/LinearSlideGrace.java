package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class LinearSlideGrace extends OpMode {

    DcMotor LiftMotorLeft;
    DcMotor LiftMotorRight;
    @Override
    public void loop() {
        float speedMultiplier = 0.5f;
        double y = gamepad2.left_stick_y;
        LiftMotorRight.setPower(-0.25*y);
        LiftMotorLeft.setPower(0.25*y);
        LiftMotorLeft.setTargetPosition();
    }
    @Override
    public void init() {
        LiftMotorLeft = hardwareMap.get(DcMotor.class, "");
        LiftMotorRight = hardwareMap.get(DcMotor.class, "");






    }



}
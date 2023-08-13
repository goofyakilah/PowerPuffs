package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class SlideEncoderTest extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;

    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

        liftMotorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //reverse a motor
    }

    @Override
    public void loop() {
        telemetry.addData("encoderLeft", liftMotorL.getCurrentPosition());
        telemetry.addData("encoderRight", liftMotorR.getCurrentPosition());
        telemetry.update();
    }
}

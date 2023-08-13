package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class SlideEncoderTest extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;

    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");


        liftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);
//        liftMotorL.setDirection(DcMotorSimple.Direction.REVERSE);
        //reverse a motor
    }

    @Override
    public void loop() {
        telemetry.addData("encoderLeft", liftMotorL.getCurrentPosition());
        telemetry.addData("encoderRight", liftMotorR.getCurrentPosition());
        telemetry.update();
    }
}

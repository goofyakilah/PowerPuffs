package org.firstinspires.ftc.teamcode.MecanumDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class testytest extends OpMode {
DcMotor RFMotor;
DcMotor RBMotor;
DcMotor LFMotor;
DcMotor LBMotor;
public float speedLimit = 0.5f;
    @Override
    public void init() {
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);
    }


    @Override
    public void loop() {
        double y = gamepad1.left_stick_y; // negate y if flipped
        double x = gamepad1.left_stick_x * 1.1;
        double rx = gamepad1.right_stick_x;

        double LFPower = y + x + rx;
        double LBPower = y - x + rx;
        double RFPower = y - x - rx;
        double RBPower = y + x - rx;

        LFMotor.setPower(LFPower);
        LBMotor.setPower(LBPower);
        RFMotor.setPower(RFPower);
        RBMotor.setPower(RBPower);
    }
}

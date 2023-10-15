package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class ActiveIntakeTesting extends OpMode {
    DcMotor intakemotor;
    public double SpeedLimiter = 1.0;
    @Override
    public void init() {

    intakemotor= hardwareMap.get(DcMotor.class,"intake");
    }

    @Override
    public void loop() {
    double leftTrigger = gamepad1.left_trigger;
    double y = gamepad1.right_stick_y;
    intakemotor.setPower(SpeedLimiter * -y);
    }
}




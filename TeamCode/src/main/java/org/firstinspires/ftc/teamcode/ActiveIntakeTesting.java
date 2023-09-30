package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class ActiveIntakeTesting extends OpMode {
    DcMotor IntakeMotor;
    public double SpeedLimiter = 0.5;
    @Override
    public void init() {

    IntakeMotor= hardwareMap.get(DcMotor.class,"IntakeMotor");
    }

    @Override
    public void loop() {
    double leftTrigger = gamepad1.left_trigger;
    double y = gamepad1.right_stick_y;
    IntakeMotor.setPower(SpeedLimiter * -y);
    }
}




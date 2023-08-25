package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class ServosCarolina extends OpMode{
    public Servo servo;
    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class,"Claw");
        servo = hardwareMap.get(Servo.class,"Arm");
servo.setDirection(Servo.Direction.REVERSE);
servo.setPosition(0.5);
    }

    @Override
    public void loop() {
if (gamepad1.left_trigger > 0){}
    }
}


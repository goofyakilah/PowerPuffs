package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoSuzy extends OpMode {
//    public Servo servo1;
    public Servo servo2;
    boolean push = false;
    @Override
    public void init() {
//        servo1 = hardwareMap.get(Servo.class,"Claw");
        servo2 = hardwareMap.get(Servo.class,"wrist");
    }

    @Override
    public void loop() {
//
//    if (gamepad1.left_trigger > 0.3) {
//        servo1.setPosition(0.35);
//    }
//
//    if (gamepad1.right_trigger > 0.3) {
//        servo1.setPosition(0.15);
//    }
    if (gamepad1.a && !push) {
        servo2.setPosition(0);
    }
    if (gamepad1.b && !push) {
        servo2.setPosition(-0.7);
    }
    }
}
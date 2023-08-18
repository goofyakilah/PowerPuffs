package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
public class ServosSuzy extends OpMode {

    public Servo servo;

    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class,"Servo");
        servo.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void loop() {

    if (gamepad1.left_trigger > 0.3) {
        servo.setPosition(0.5);
    }
    }
}

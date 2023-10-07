package org.firstinspires.ftc.teamcode.Servos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;


public class Servos extends OpMode {

    public Servo servo;

    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class, "Servo");
        servo.setDirection(Servo.Direction.REVERSE);
        servo.setPosition(0.5);
    }

    @Override
    public void loop() {

    }
}

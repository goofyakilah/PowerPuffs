package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoGrace extends OpMode {

    public Servo servo1;
//    public Servo servo2;
//    boolean move = false;


    @Override
    public void init() {
        servo1 = hardwareMap.get(Servo.class, "Claw");
        servo1.setDirection(Servo.Direction.REVERSE);
//        servo2 = hardwareMap.get(Servo.class, "Servo2");
//        servo2.setDirection(Servo.Direction.REVERSE);
    }


    @Override
    public void loop() {
        if (gamepad1.left_trigger > 0.3) {
            servo1.setPosition(0.5);}

        if (gamepad1.right_trigger > 0.3) {
            servo1.setPosition(0.3);}

//        if (gamepad1.a && !move){
//            servo2.setPosition(0.3);}
//
//        if (gamepad1.a && !move){
//            servo2.setPosition(0.3);}
    }

    }
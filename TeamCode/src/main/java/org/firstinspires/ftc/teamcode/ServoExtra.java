package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoExtra extends OpMode {

    public Servo servo1;
    public Servo servo2;
//    public Servo servo3;
//    public Servo servo4;
    boolean move = false;

    @Override
    public void init() {
        servo1 = hardwareMap.get(Servo.class, "Claw");
        servo2 = hardwareMap.get(Servo.class, "Claw");
        servo2.setDirection(Servo.Direction.REVERSE);
//        servo4 = hardwareMap.get(Servo.class, "claw");
//        servo4.setDirection(Servo.Direction.REVERSE);
//       servo3 = hardwareMap.get(Servo.class, "Claw");

    }


    @Override
    public void loop() {

        if (gamepad1.left_trigger > 0.3) {
            servo1.setPosition(0.15);
            move = true;

        } else if (gamepad1.right_trigger > 0.3) {
//            servo1.setPosition(0.38); //max
            servo1.setPosition(0.35);
            move = true;

        } else if (gamepad1.a && !move) {
            servo2.setPosition(0);
            move = true;

        } else if (gamepad1.y && !move) {
            servo2.setPosition(-0.7);
            move = true;

//        }else if (gamepad1.b && !move) {
//            servo3.setPosition(0.1);
//            servo4.setPosition(0.1);
//            move = true;
//
//        } else if (gamepad1.x && !move) {
//            servo3.setPosition(0);
//            servo4.setPosition(0);
//            move = true;

        } else {


        }




    }

    }
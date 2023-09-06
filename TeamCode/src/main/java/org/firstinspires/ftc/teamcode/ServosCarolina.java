package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class ServosCarolina extends OpMode{
    public Servo Claw;
    public Servo Wrist;
    public Servo RightArm;
    public Servo LeftArm;

    @Override
    public void init() {
        Claw = hardwareMap.get(Servo.class,"Claw");
        RightArm = hardwareMap.get(Servo.class,"Arm");
        Wrist = hardwareMap.get(Servo.class,"wrist");
        LeftArm = hardwareMap.get(Servo.class, "arm");

RightArm.setDirection(Servo.Direction.REVERSE);

    }
    @Override
public void loop() {
        if (gamepad1.left_trigger >= 0.3) {
            Claw.setPosition(0.15);
        } else if (gamepad1.right_trigger >= 0.3) {
            Claw.setPosition(0.35); }


        else if (gamepad1.left_bumper) {
            RightArm.setPosition(0.84);
            LeftArm.setPosition(0.94);
        }

    }
}


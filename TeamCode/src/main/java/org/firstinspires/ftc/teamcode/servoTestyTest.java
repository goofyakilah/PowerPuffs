package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "servoTestyTest", group = "TeleOp")
public class servoTestyTest extends LinearOpMode {
    public Servo Claw;
    public Servo Wrist;
    public Servo RightArm;
    public Servo LeftArm;

    @Override
    public void runOpMode() {

        Claw = hardwareMap.get(Servo.class,"Claw");
        RightArm = hardwareMap.get(Servo.class,"Arm");
        Wrist = hardwareMap.get(Servo.class,"wrist");
        LeftArm = hardwareMap.get(Servo.class, "arm");

        RightArm.setDirection(Servo.Direction.REVERSE);

        waitForStart();
            if (gamepad1.left_trigger >= 0.3) {
                Claw.setPosition(0.15);
            } else if (gamepad1.right_trigger >= 0.3) {
                Claw.setPosition(0.35);
            } else if (gamepad1.left_bumper) {
                RightArm.setPosition(0.84);
                LeftArm.setPosition(0.94);
            }
            // attempt to bring servos back to initial position- would that value be zero?
        sleep(5000);
            Claw.setPosition(0);
            RightArm.setPosition(0);
            LeftArm.setPosition(0);

        }




    }


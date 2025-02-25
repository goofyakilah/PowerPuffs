package org.firstinspires.ftc.teamcode.LinearSlides;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class LinearSlideJoystick extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;
    double y = gamepad1.left_stick_y;
    public float speedLimiter = 0.5f;

    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

    }
    @Override
    public void loop() {liftArmHigh();}

    public void liftArmHigh(){
        liftMotorL.setPower(speedLimiter * y);
        liftMotorR.setPower(speedLimiter * y);
        //right = counter clockwise = positive (up)
        //left = clockwise = clockwise = negative (up)

    }

}

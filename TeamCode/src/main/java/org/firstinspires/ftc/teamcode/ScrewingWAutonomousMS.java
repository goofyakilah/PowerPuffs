package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class ScrewingWAutonomousMS extends LinearOpMode {

    DcMotor RFMotor;
    DcMotor LFMotor;
    DcMotor RBMotor;
    DcMotor LBMotor;
    @Override
    public void runOpMode() throws InterruptedException {
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");

        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
// test this out? see how time functions as a measure and if functions are ok
        moveForward(0.5, 1000);
        turnLeft(0.5, 1000);
        moveForward(0.5, 500);
        turnLeft(0.5, 1000);
        moveForward(0.5, 1000);
        turnLeft(0.5, 1000);
        moveForward(0.5, 500);
        //test functions
    }

    public void moveForward(double power, int time) {
        RFMotor.setPower(power);
        LFMotor.setPower(power);
        RBMotor.setPower(power);
        LBMotor.setPower(power);
        sleep(time);
        RFMotor.setPower(0);
        LFMotor.setPower(0);
        RBMotor.setPower(0);
        LBMotor.setPower(0);
    }
    public void turnLeft(double power, int time) {
        RFMotor.setPower(-power);
        LFMotor.setPower(power);
        RBMotor.setPower(-power);
        LBMotor.setPower(power);
        sleep(time);
        RFMotor.setPower(0);
        LFMotor.setPower(0);
        RBMotor.setPower(0);
        LBMotor.setPower(0);
    }
}

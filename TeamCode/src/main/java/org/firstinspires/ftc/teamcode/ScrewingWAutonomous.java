package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class ScrewingWAutonomous extends LinearOpMode {

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

        RFMotor.setPower(1);
        LFMotor.setPower(1);
        RBMotor.setPower(1);
        LBMotor.setPower(1);
        sleep(1000);
        RFMotor.setPower(0);
        LFMotor.setPower(0);
        RBMotor.setPower(0);
        LBMotor.setPower(0);

        //test function
        public void moveForward (int power, int time){
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
//test function

    }
}

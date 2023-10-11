package org.firstinspires.ftc.teamcode.MecanumDrive;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous
public class AutonomousDrive extends LinearOpMode {
    DcMotor RFMotor;
    DcMotor LFMotor;
    DcMotor RBMotor;
    DcMotor LBMotor;
    public float speedMultiplier = 0.5f;

    @Override
    public void runOpMode() throws InterruptedException {
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);
    }
    public void moveForward() {
            LFMotor.setPower(0.5);
            LBMotor.setPower(0.5);
            RFMotor.setPower(0.5);
            RBMotor.setPower(0.5);
        }
    }



}

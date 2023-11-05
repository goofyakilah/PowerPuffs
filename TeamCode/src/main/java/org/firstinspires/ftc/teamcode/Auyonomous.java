package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

    @Autonomous
    public class Auyonomous extends LinearOpMode {


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

            // ticks per revolution
            RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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
            public void moveForward(int distance)(int power){
                RFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                LFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                RBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                LBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                RFMotor.setTargetPosition(distance);
                RBMotor.setTargetPosition(distance);
                LFMotor.setTargetPosition(distance);
                LBMotor.setTargetPosition(distance);
                RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                RFMotor.setPower(power);
                RBMotor.setPower(power);
                LFMotor.setPower(power);
                LBMotor.setPower(power);
                while (RFMotor.isBusy() || RBMotor.isBusy() || LFMotor.isBusy() || LBMotor.isBusy() ||false) {}
                RFMotor.setPower(0);
                LFMotor.setPower(0);
                RBMotor.setPower(0);
                LBMotor.setPower(0);

            }


        }
    }


}

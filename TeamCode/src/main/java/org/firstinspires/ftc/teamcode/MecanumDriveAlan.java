package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MecanumDriveAlan extends OpMode {
    DcMotor RFMotor;
    DcMotor LFMotor;
    DcMotor RBMotor;
    DcMotor LBMotor;

    public void moveDriveTrain() {
        float x1 = -gamepad1.left_stick_x;
        float y1 = gamepad1.left_stick_y;
        float x2 = gamepad1.right_stick_x;

        double fl = x1 + y1 + x2;
        double bl = -x1 + y1 + x2;
        double fr = -x1 + y1 - x2;
        double br = x1 + y1 - x2;

        LFMotor.setPower(fl);
        LBMotor.setPower(bl);
        RFMotor.setPower(fr);
        RBMotor.setPower(br);

    }
    @Override
    public void init() {
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");

        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop(){
        moveDriveTrain();
    }
}



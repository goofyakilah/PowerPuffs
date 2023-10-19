package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@TeleOp
public class Drivetwoverticaltwoh extends OpMode {
    DcMotor RFMotor; // Mecanum drive motors
    DcMotor LFMotor; // Mecanum drive motors
    DcMotor RBMotor; // Mecanum drive motors
    DcMotor LBMotor; // Mecanum drive motors

    public float speedMultiplier = 0.5f; // Mecanum drive motors power reduce
    public float speedLimiter = 0.5f;
    @Override
    public void init() {
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor"); // Mecanum drive
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

    public void moveDriveTrain() {
        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double fl = y - x - rx;
        double bl = y + x - rx;
        double fr = y + x + rx;
        double br = y - x + rx;

        LFMotor.setPower(fl*speedMultiplier);
        LBMotor.setPower(bl*speedMultiplier);
        RFMotor.setPower(fr*speedMultiplier);
        RBMotor.setPower(br*speedMultiplier);

        telemetry.addData("y",y);
        telemetry.addData("x",x);
        telemetry.addData("fl",fl);
        telemetry.addData("bl",bl);
        telemetry.addData("fr",fr);
        telemetry.addData("br",br);
        telemetry.update();
    }

}

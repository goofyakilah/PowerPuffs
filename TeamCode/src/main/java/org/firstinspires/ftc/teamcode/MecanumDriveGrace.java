package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MecanumDriveGrace extends OpMode {

    DcMotor RFMotor;
    DcMotor LFMotor;
    DcMotor RBMotor;
    DcMotor LBMotor;

    public float speedMultiplier = 0.5f;

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
    public void loop(){ //this is the loop that repeats while the program is running
        moveDriveTrain();
    }

    public void moveDriveTrain() {


        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;


        //i think right now moving forwards and backwards are correct, but strafing and turning are inverted
        // (if you try to strafe left, the robot strafes right; if you try to strafe right, the robot strafes left
        // if you try to turn left, the robot turns right; if you try to turn right, the robot turns left)
        //change the +s and -s to fix
        double fl = y + x - rx;
        double bl = y - x - rx;
        double fr = y - x + rx;
        double br = y + x + rx;


        LFMotor.setPower(fl*speedMultiplier);
        LBMotor.setPower(bl*speedMultiplier);
        RFMotor.setPower(fr*speedMultiplier);
        RBMotor.setPower(br*speedMultiplier);

    }
}






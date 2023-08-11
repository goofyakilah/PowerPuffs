package org.firstinspires.ftc.teamcode; //tells the program where this file is located

// import statements
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp //tells the program that this is a teleop file and will appear in the dropdown for teleop files on the driver station
public class MecanumDriveAlan1 extends OpMode {

    //declare motors
    DcMotor LFMotor;
    DcMotor LBMotor;
    DcMotor RFMotor;
    DcMotor RBMotor;


    //limit the speed of the motors so we can see which direction the wheels are moving
    public float speedMultiplier = 0.30f;

    @Override
    public void init() {
        //assigning the motors

        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");

        //reversing the motors
        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop(){ //this is the loop that repeats while the program is running
        moveDriveTrain();
    }

    public void moveDriveTrain() {

        //left stick up is move forward
        //left stick down is move backward
        //left stick left is strafe left
        //left stick right is strafe right
        //right stick left is turn left
        //right stick right is turn right
        //i think up is positive and down is negative
        //i think left is positive and right is negative


        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x* 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;


//i think right now moving forwards and backwards are correct, but strafing and turning are inverted
// (if you try to strafe left, the robot strafes right; if you try to strafe right, the robot strafes left
// if you try to turn left, the robot turns right; if you try to turn right, the robot turns left)
//change the +s and -s to fix
// Denominator is the largest motor power (absolute value) or 1
// This ensures all the powers maintain the same ratio, but only when
// at least one is out of the range [-1, 1]

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double fl = speedMultiplier * (y - x - rx) / denominator;
        double bl = speedMultiplier * (y + x - rx) / denominator;
        double fr = speedMultiplier * (y - x + rx) / denominator;
        double br = speedMultiplier * (y + x + rx) / denominator;
        LFMotor.setPower(fl);
        LBMotor.setPower(bl);
        RFMotor.setPower(fr);
        RBMotor.setPower(br);

    }
}



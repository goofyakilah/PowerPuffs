package org.firstinspires.ftc.teamcode; //tells the program where this file is located

// import statements
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp //tells the program that this is a teleop file and will appear in the dropdown for teleop files on the driver station
public class LiftCodeAlan extends OpMode {

    //declare motors
    DcMotor RFMotor;
    DcMotor LFMotor;
    DcMotor RBMotor;
    DcMotor LBMotor;

    DcMotor liftMotorLeft;

    DcMotor liftMotorRight;

    //limit the speed of the motors so we can see which direction the wheels are moving
    public float speedMultiplier = 0.5f;

    private int[] heights;
    private int currentIndex = 0;

    private float motorPower = 0.5f;

    @Override
    public void init() {
        //assigning the motors
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");

        liftMotorRight = hardwareMap.get(DcMotor.class, "liftMotorRight");
        liftMotorLeft = hardwareMap.get(DcMotor.class, "liftMotorLeft");

        //reversing the motors
        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop(){
        moveDriveTrain();
        liftController(gamepad1.left_bumper, gamepad1.right_bumper);
    }

    public void moveDriveTrain() {
        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double fl = y + x + rx;
        double bl = y - x + rx;
        double fr = y + x - rx;
        double br = y - x - rx;

        LFMotor.setPower(fl*speedMultiplier);
        LBMotor.setPower(bl*speedMultiplier);
        RFMotor.setPower(fr*speedMultiplier);
        RBMotor.setPower(br*speedMultiplier);
    }

    public void liftController(boolean leftkeybind, boolean rightkeybind)
    {
        if (leftkeybind){
            if (currentIndex == 0)
            {
                currentIndex = 0;
            }
            else
            {
                currentIndex = currentIndex - 1;
            }
            liftMotorLeft.setTargetPosition(heights[currentIndex]);
            liftMotorRight.setTargetPosition(heights[currentIndex]);
            liftMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorLeft.setPower(motorPower);
            liftMotorRight.setPower(motorPower);
        }
        if (rightkeybind)
        {
            if (currentIndex == 3)
            {
                currentIndex = 3;
            }
            else
            {
                currentIndex = currentIndex + 1;
            }
            liftMotorLeft.setTargetPosition(heights[currentIndex]);
            liftMotorRight.setTargetPosition(heights[currentIndex]);
            liftMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorLeft.setPower(motorPower);
            liftMotorRight.setPower(motorPower);
        }
    }


}



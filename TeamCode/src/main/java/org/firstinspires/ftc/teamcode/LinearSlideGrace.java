package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinearSlideGrace extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;


    double y = gamepad2.left_stick_y;

    boolean move = false;

    public int low = 500;
    public int medium = 700;
    public int high =1000;
    public int zero =0;

    public float speedLimiter = 0.5f;

    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

        int positionL = liftMotorL.getCurrentPosition();
        int positionR = liftMotorR.getCurrentPosition();

        liftMotorR.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        liftMotorL.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        liftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {

    if (gamepad2.a && !move) {
        int targetposition = 500;
        liftMotorL.setTargetPosition(low);
        liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setTargetPosition(low);
        liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setPower(0.2);
        liftMotorL.setPower(0.2);
        move = true; }

    if (gamepad2.b && !move) {
        int targetposition = 700;
        liftMotorL.setTargetPosition(medium);
        liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setTargetPosition(medium);
        liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setPower(0.2);
        liftMotorL.setPower(0.2);
        move = true; }

    if (gamepad2.y && !move) {
        int targetposition = 1000;
        liftMotorL.setTargetPosition(high);
        liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setTargetPosition(high);
        liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setPower(0.2);
        liftMotorL.setPower(0.2);
        move = true; }

    if (gamepad2.x && !move) {
        int targetposition = 0;
        liftMotorL.setTargetPosition(zero);
        liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setTargetPosition(zero);
        liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setPower(0.2);
        liftMotorL.setPower(0.2);
        move = true; }

    if (move &&!liftMotorR.isBusy() &&!liftMotorL.isBusy()){
        liftMotorL.setPower(0);
        liftMotorR.setPower(0);
        move=false;
    }



    liftArmHigh();
    }




    public void liftArmHigh(){
        liftMotorL.setPower(speedLimiter * y);
        liftMotorR.setPower(speedLimiter * y);


    }

}

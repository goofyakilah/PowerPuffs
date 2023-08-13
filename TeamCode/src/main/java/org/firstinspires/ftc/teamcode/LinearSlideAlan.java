package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinearSlideAlan extends OpMode{

    DcMotor liftMotorL;
    DcMotor liftMotorR;

    public double speedLimiter = 0.5;
    public double power = 0.5;

    public int[] values = {0, 1100, 2200, 3500};
    public int currentIndex = 0;
    public int position = 0;

    public int GROUND = 0;
    public int LOW = 1100;
    public int MID = 2200;
    public int HIGH = 3500;




    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");

        liftMotorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    @Override
    public void loop() {
        liftController(gamepad1.a, gamepad1.b);
        setGround(gamepad1.a);
        setLow(gamepad1.x);
        setMID(gamepad1.b);
        setHIGH(gamepad1.y);
    }

    public void setGround(boolean keybind){
        if(keybind) {
            moveLift(GROUND);
        }
    }
    public void setLow(boolean keybind){
        if(keybind) {
            moveLift(LOW);
        }
    }
    public void setMID(boolean keybind){
        if(keybind) {
            moveLift(MID);
        }
    }
    public void setHIGH(boolean keybind){
        if(keybind) {
            moveLift(HIGH);
        }
    }

    public void liftController(boolean up, boolean down){
        if(up)
        {
            currentIndex = (currentIndex + 1) % values.length;
        }
        if(down)
        {
            currentIndex = (currentIndex - 1 + values.length) % values.length;
        }
        position = values[currentIndex];
        moveLift(position);
    }

    public void moveLift(int position){

        int currentPositionL = liftMotorL.getCurrentPosition();
        int positionDifferenceL = Math.abs(currentPositionL - position);

//        double powerModifier = Math.min(1.0, positionDifferenceL / 100.0);

        liftMotorL.setTargetPosition(position);
        liftMotorR.setTargetPosition(position);
        if(positionDifferenceL < 10){
            liftMotorR.setPower(0);
            liftMotorL.setPower(0);
        } else {
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setPower(power*speedLimiter/*powerModifier*/);
            liftMotorL.setPower(power*speedLimiter/*powerModifier*/);
        }
    }
}

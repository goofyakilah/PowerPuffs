package org.firstinspires.ftc.teamcode.LinearSlides;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class LinearSlideAveri extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;

    public float speedLimiter = 0.5f;
    boolean move = false;

    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");
        int positionL = liftMotorL.getCurrentPosition();
        int positionR = liftMotorR.getCurrentPosition();

        liftMotorR.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        liftMotorL.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        liftMotorL.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
    if(gamepad1.a && !move){
        int targetposition = 1500;
        liftMotorL.setTargetPosition(targetposition);
        liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setTargetPosition(targetposition);
        liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorL.setPower(0.2);
        liftMotorR.setPower(0.2);

        move = true; }


    if(move && !liftMotorL. isBusy() && !liftMotorR.isBusy()){
            liftMotorR.setPower(0);
            liftMotorL.setPower(0);

            move = false;
        }


    boolean b = gamepad1.b;
    boolean yl = gamepad1.y;
    boolean x = gamepad1.x;
    boolean a = gamepad1.a;

//    public int getTargetposition(){};

}}

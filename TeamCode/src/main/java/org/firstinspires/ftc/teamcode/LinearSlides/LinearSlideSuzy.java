package org.firstinspires.ftc.teamcode.LinearSlides;

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinearSlideSuzy extends OpMode {
    DcMotor liftMotorL;
    DcMotor liftMotorR;
    boolean push = false;
    public void liftArmHigh(){
        boolean a = gamepad1.a;
        boolean b = gamepad1.b;
        boolean x = gamepad1.x;
        boolean y = gamepad1.y;
    }
    @Override
    public void init() {
        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL");
        liftMotorR = hardwareMap.get(DcMotor.class, "liftMotorR");
        int positionL = liftMotorL.getCurrentPosition();
        int positionR = liftMotorR.getCurrentPosition();

        liftMotorR.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        liftMotorL.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        liftMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {

        if (gamepad1.a && !push) {
            int setTargetPosition = 0;
            liftMotorL.setTargetPosition(setTargetPosition);
            liftMotorR.setTargetPosition(setTargetPosition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setPower(0.2);
            liftMotorR.setPower(0.2);
            push = true;
        }
        if (gamepad1.b && !push) {
            int setTargetPosition = 400;
            liftMotorL.setTargetPosition(setTargetPosition);
            liftMotorR.setTargetPosition(setTargetPosition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setPower(0.2);
            liftMotorR.setPower(0.2);
            push = true;
        }
        if (gamepad1.x && !push) {
            int setTargetPosition = 800;
            liftMotorL.setTargetPosition(setTargetPosition);
            liftMotorR.setTargetPosition(setTargetPosition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setPower(0.2);
            liftMotorR.setPower(0.2);
            push = true;
        }
        if (gamepad1.y && !push) {
            int setTargetPosition = 1200;
            liftMotorL.setTargetPosition(setTargetPosition);
            liftMotorR.setTargetPosition(setTargetPosition);
            liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftMotorL.setPower(0.2);
            liftMotorR.setPower(0.2);
            push = true;
        }


        if (push && !liftMotorL.isBusy() && !liftMotorR.isBusy()) {
            liftMotorL.setPower(0);
            liftMotorR.setPower(0);
            push = false;
        }
    }
}
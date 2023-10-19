//Mecanum+Slides tested
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@TeleOp
public class PowerpuffV1 extends OpMode {

    DcMotor RFMotor; // Mecanum drive motors
    DcMotor LFMotor; // Mecanum drive motors
    DcMotor RBMotor; // Mecanum drive motors
    DcMotor LBMotor; // Mecanum drive motors
    DcMotor liftMotorL; // linear slides motors
    DcMotor liftMotorR; // linear slides motors
    boolean move = false;
    private static final double SLIDE_POWER = 0.9; // linear slides Adjust as needed
    private static final int POSITION_A = 1000;   // linear slides Adjust these positions as needed
    private static final int POSITION_B = 2000; // linear slides
    private static final int POSITION_X = 0; // linear slides
    private static final int POSITION_Y = 2500; // linear slides
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

        liftMotorL = hardwareMap.get(DcMotor.class, "liftMotorL"); // linear slides
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
    public void loop(){

        moveDriveTrain();
        if (gamepad1.a && !move) {
            moveSlideToPosition(POSITION_A);
        }  else if (gamepad1.b && !move) {
            moveSlideToPosition(POSITION_B);
        }   else if (gamepad1.y && !move) {
            moveSlideToPosition(POSITION_Y);
        }   else if (gamepad1.x && !move) {
            moveSlideToPosition(POSITION_X);
        }   else  {
            liftArmHigh();
        }

    }

    public void moveDriveTrain() {
        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double fl = y + x + rx;
        double bl = y - x + rx;
        double fr = y - x - rx;
        double br = y + x - rx;

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
    private void moveSlideToPosition(int targetPosition) {
        liftMotorL.setTargetPosition(targetPosition);
        liftMotorR.setTargetPosition(targetPosition);
        liftMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorR.setPower(SLIDE_POWER);
        liftMotorL.setPower(SLIDE_POWER);
        move=true;
        while (liftMotorL.isBusy() && liftMotorR.isBusy() && move) {
            // Wait until the motor reaches the target position
        }
        liftMotorL.setPower(0);
        liftMotorR.setPower(0);
        liftMotorL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotorR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        move=false;
    }

    public void liftArmHigh(){
        double y = - gamepad1.right_stick_y;
        liftMotorL.setPower(speedLimiter * y);
        liftMotorR.setPower(speedLimiter * y);

    }



}
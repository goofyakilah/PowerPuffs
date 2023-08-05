

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class MecanumDrive extends OpMode {
    DcMotor RFMotor;
    DcMotor LFMotor;
    DcMotor RBMotor;
    DcMotor LBMotor;

    public void moveDriveTrain(){
        double vertical;
        double horizontal;

        vertical= gamepad1.left_stick_y;
        horizontal= gamepad1.left_stick_x;
        double pivot = gamepad1.right_stick_x;

        RFMotor.setPower(pivot+);
        RBMotor.setPower(pivot+ );
    @Override
    public void init() {
        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");
    }

    @Override
    public void init_loop(){

    }

    @Override
    public void loop(){

    }
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}

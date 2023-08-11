package org.firstinspires.ftc.teamcode;

public class name {
}
    DcMotor RFMotor;
    DcMotor LfMotor;
    DcMotor RBMotor;
    DcMotor LBMotor;

    public void moveDriveTrain(){
        double vertical;
        double horizontal;
        double pivot;
        vertical = -gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot - gamepad1.right_stickx;

        RFMotor.setPower(pivot+ (-vertical + horizontal));
        RBMotor.setPower(pivot+ (-vertical - horizontal));
        LFMotor.setPower(pivot+ (-vertical - horizontal));
        RFMotor.setPower(pivot+ (-vertical + horizontal));
    }
    @Override
    public void init() {
        RFMotor - hardwareMap.get(DcMotor,class, deviceName: "RFMotor");
        LfMotor - hardwareMap.get(DcMotor,class, deviceName: "LFMotor");
        LBMotor - hardwareMap.get(DcMotor,class, deviceName: "LBMotor");
        RBMotor - hardwareMap.get(DcMotor,class, deviceName: "RBMotor");
    }

    @Override
public void init_loop(){

    }
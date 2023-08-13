//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//@TeleOp
//public class test {
//
//    DcMotor LLift;
//    DcMotor RLift;
//
//
//    public float speedMultiplier = 0.5f;
//
//
//    @Override
//    public void init() {
//        LLift = hardwareMap.get(DcMotor.class, "LLift");
//        RLift = hardwareMap.get(DcMotor.class, "RLift");
//
//    }
//
//    @Override
//    public void loop(){
//        LiftArm();
//    }
//
//    public void LiftArm() {
//
//        double y = gamepad2.left_stick_y;
//
//
//        double LL = y
//        double RL = -y
//
//
//        LLift.setPower(LL*speedMultiplier);
//        RLift.setPower(RL*speedMultiplier);
//    }
//
//}

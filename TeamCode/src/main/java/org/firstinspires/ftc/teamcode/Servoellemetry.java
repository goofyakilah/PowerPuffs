
package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Servoellemetry extends OpMode {

    public Servo servo1;
//    public Servo servo2;
//    boolean move = false;
    private static final double CLAW_OPEN_POSITION = 0.8;    // Adjust as needed
    private static final double CLAW_HALF_CLOSED_POSITION = 0.5; // Adjust as needed
    private static final double CLAW_CLOSED_POSITION = 0.2;   // Adjust as needed
    private static final double CLAW_INCREMENT = 0.02;        // Adjust as needed

    @Override
    public void init() {
        servo1 = hardwareMap.get(Servo.class, "Claw");
        servo1.setDirection(Servo.Direction.REVERSE);
        double clawPosition = CLAW_OPEN_POSITION;
        servo1.setPosition(clawPosition);

//        servo2 = hardwareMap.get(Servo.class, "Servo2");
//        servo2.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if (gamepad1.left_trigger > 0.3) {
            servo1.setPosition(0.5);}

        if (gamepad1.right_trigger > 0.3) {
            servo1.setPosition(0.3);}

//        if (gamepad1.a && !move){
//            servo2.setPosition(0.3);}
//
//        if (gamepad1.a && !move){
//            servo2.setPosition(0.3);}
    }

}
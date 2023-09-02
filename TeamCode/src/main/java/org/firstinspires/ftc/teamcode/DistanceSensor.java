package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREV2mDistance;

@TeleOp
public class DistanceSensor extends OpMode {
    public DcMotor LBMotor;
    public SensorREV2mDistance DS;

    @Override
    public void init() {
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");
        DS = hardwareMap.get(SensorREV2mDistance.class, "Distance Sensor");
    }

    @Override
    public void loop(){

//        telemetry.addData("Distance (cm)", SensorREV2mDistance.getDistance(DistanceUnit.CM));
        telemetry.update();

//        if (DS.getDistance(DistanceUnit.CM) <= 10) {
//            LBMotor.setPower(1);
//        }
//        if (DS.getDistance(DistanceUnit.CM) >= 10) {
//            LBMotor.setPower(0);
//        }

    }


}

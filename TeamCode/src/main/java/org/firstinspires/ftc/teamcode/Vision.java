package org.firstinspires.ftc.teamcode;

import android.annotation.SuppressLint;
import android.util.Size;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.ExposureControl;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.GainControl;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;
import java.util.concurrent.TimeUnit;

@TeleOp
public class Vision  extends LinearOpMode {
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode() throws InterruptedException {

        AprilTagProcessor tagProcessor = new AprilTagProcessor.Builder()
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
                .setTagLibrary(AprilTagGameDatabase.getCenterStageTagLibrary())
                .build();

        VisionPortal visionPortal = new VisionPortal.Builder()
                .addProcessor(tagProcessor)
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .setCameraResolution(new Size(640, 480))
                .setStreamFormat(VisionPortal.StreamFormat.MJPEG)
                .build();

        while (visionPortal.getCameraState() != VisionPortal.CameraState.STREAMING) {}
        ExposureControl exposure = visionPortal.getCameraControl(ExposureControl.class);
        exposure.setMode(ExposureControl.Mode.Manual);
        exposure.setExposure(15, TimeUnit.MILLISECONDS);

        GainControl gain = visionPortal.getCameraControl(GainControl.class);
        gain.setGain(255);

        waitForStart();

        while(!isStopRequested() && opModeIsActive()) {
//            if (tagProcessor.getDetections().size()> 0) {
//                AprilTagDetection tag1 = tagProcessor.getDetections().get(0);
//                AprilTagDetection tag2 = tagProcessor.getDetections().get(0);
//                AprilTagDetection tag3 = tagProcessor.getDetections().get(0);
//                AprilTagDetection tag4 = tagProcessor.getDetections().get(0);
//                AprilTagDetection tag5 = tagProcessor.getDetections().get(0);
//                AprilTagDetection tag6 = tagProcessor.getDetections().get(0);
             List<AprilTagDetection> detections =tagProcessor.getDetections();
             for(AprilTagDetection detection : detections){
                 AprilTagPoseFtc ftcPose=detection.ftcPose;
                 telemetry.addData("id", detection.id);
                 telemetry.addLine(String.format("XYZ %6.2f %6.2f %6.2f", ftcPose.x, ftcPose.y, ftcPose.z));
                 telemetry.addData("roll", ftcPose.roll);
                 telemetry.addData("pitch", ftcPose.pitch);
                 telemetry.addData("yaw", ftcPose.yaw);
             }





//                telemetry.addData("id", tag6.id);
//                telemetry.addLine(String.format("XYZ %6.2f %6.2f %6.2f", tag6.ftcPose.x, tag6.ftcPose.y, tag6.ftcPose.z));
//                telemetry.addData("roll", tag6.ftcPose.roll);
//                telemetry.addData("pitch", tag6.ftcPose.pitch);
//                telemetry.addData("yaw", tag6.ftcPose.yaw);


            telemetry.update();
        }
    }
}


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Driver {

    private ElapsedTime runtime = new ElapsedTime();

    /* Declare OpMode members. */
    private DcMotor leftDrive = null;
    private DcMotor         rightDrive  = null;

    private HardwareMap hardwareMap;


    static final double     FORWARD_SPEED = 0.2;
    static final double     TURN_SPEED    = 0.2;

    private Telemetry telemetry;



    private int driveTime = 1;

    public Driver(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        this.leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        this.rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void forward() {
        runtime.reset();
        while (runtime.seconds() < driveTime) {
            leftDrive.setPower(FORWARD_SPEED);
            rightDrive.setPower(FORWARD_SPEED);
            telemetry.addData("Path", "Leg: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void right() {
        runtime.reset();
        while (runtime.seconds() < driveTime) {
            leftDrive.setPower(TURN_SPEED);
            rightDrive.setPower(-TURN_SPEED);
            telemetry.addData("Path", "Leg: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void left() {
        runtime.reset();
        while (runtime.seconds() < driveTime) {
            leftDrive.setPower(-TURN_SPEED);
            rightDrive.setPower(TURN_SPEED);
            telemetry.addData("Path", "Leg: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void back() {
        runtime.reset();
        while (runtime.seconds() < driveTime) {
            leftDrive.setPower(-FORWARD_SPEED);
            rightDrive.setPower(-FORWARD_SPEED);
            telemetry.addData("Path", "Leg: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void stop() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}

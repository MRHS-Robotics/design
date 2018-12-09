package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Drive")
public class Drive extends OpMode {
    private DcMotor axis1Left;
    private DcMotor axis1Right;
    private DcMotor axis2Left;
    private DcMotor axis2Right;
    private DcMotor slide1;
    private DcMotor slide2;
    private Servo claw;
    private Servo arm;

    @Override
    public void init() {
        axis1Left = hardwareMap.get(DcMotor.class, "axis1 Left");
        axis1Right = hardwareMap.get(DcMotor.class, "axis1 Right");
        axis2Left = hardwareMap.get(DcMotor.class, "axis2 Left");
        axis2Right = hardwareMap.get(DcMotor.class, "axis2 Right");
        slide1 = hardwareMap.get(DcMotor.class, "slide1");
        slide2 = hardwareMap.get(DcMotor.class, "slide2");
        claw = hardwareMap.get(Servo.class, "Claw");
        arm = hardwareMap.get(Servo.class, "Arm");


        axis1Left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        axis1Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        axis1Right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        axis1Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        axis2Left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        axis2Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        axis2Right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        axis2Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        slide1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        slide2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        claw.setPosition(Servo.MAX_POSITION);
        arm.setPosition(Servo.MIN_POSITION);

    }

    @Override
    public void loop() {


        //keeps arm up
        arm.setPosition(Servo.MIN_POSITION);

        //Driving
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;

        // choose a dominant axis and zero the other
        if (Math.abs(x) > Math.abs(y)) {
            y = 0.0d;
        } else {
            x = 0.0d;
        }

        axis1Left.setPower(-(y + x)/2);
        axis1Right.setPower((y + x)/2);

        axis2Left.setPower(-(y - x)/2);
        axis2Right.setPower((y - x)/2);

        //Spinning!
//         while (gamepad1.right_bumper && !gamepad1.left_bumper && x == 0 && y == 0){
        while (gamepad1.right_bumper) {
            axis1Left.setPower(-0.5);
            axis1Right.setPower(-0.5);
            axis2Left.setPower(-0.5);
            axis2Right.setPower(-0.5);
        }
//        while (gamepad1.left_bumper && !gamepad1.right_bumper && x == 0 && y == 0){
        while (gamepad1.left_bumper) {
            axis1Left.setPower(0.5);
            axis1Right.setPower(0.5);
            axis2Left.setPower(0.5);
            axis2Right.setPower(0.5);
        }

        //Sets claw positions
        if (gamepad1.x) {
            claw.setPosition(Servo.MAX_POSITION);
        } else if (gamepad1.b) {
            claw.setPosition(Servo.MAX_POSITION * 0.50);
        }

        //Temporary slide 1 (-2700)
        slide1.setPower(gamepad1.right_stick_y);
        slide2.setPower(-gamepad1.right_stick_y);


        // Reports to phone
        telemetry.addData("Claw position: %d", claw.getPosition());
        telemetry.addData("Arm position: %d", arm.getPosition());
        telemetry.addData("Slide 1 current position: ", slide1.getCurrentPosition());
        telemetry.addData("Slide 2 current position: ", slide2.getCurrentPosition());
        telemetry.update();


    }
}

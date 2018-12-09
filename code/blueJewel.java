//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//
//@Autonomous (name = "blueJewel")
//public class blueJewel extends LinearOpMode {
//
//
//    private Servo claw;
//    private Servo arm;
//    private DcMotor axis1Left;
//    private DcMotor axis1Right;
//    private DcMotor axis2Left;
//    private DcMotor axis2Right;
//    private ElapsedTime runtime = new ElapsedTime();
//
//    @Override
//    public void runOpMode() {
//
//        claw = hardwareMap.get(Servo.class, "Claw");
//        arm = hardwareMap.get(Servo.class, "Arm");
//        axis1Left = hardwareMap.get(DcMotor.class, "axis1 Left");
//        axis1Right = hardwareMap.get(DcMotor.class, "axis1 Right");
//        axis2Left = hardwareMap.get(DcMotor.class, "axis2 Left");
//        axis2Right = hardwareMap.get(DcMotor.class, "axis2 Right");
//
//        claw.setPosition(Servo.MAX_POSITION);
//        arm.setPosition(Servo.MIN_POSITION);
//        axis1Left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        axis1Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        axis1Right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        axis1Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        axis2Left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        axis2Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        axis2Right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        axis2Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//
//        arm.setPosition(Servo.MIN_POSITION);
//
//        waitForStart();
//
//        axis1Left.setPower(-0.75);
//        axis1Right.setPower(0.75);
//        axis2Left.setPower(0.75);
//        axis2Right.setPower(-0.75);
//        runtime.reset();
//        while (opModeIsActive() && (runtime.seconds() < 1.5)) {
//            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
//            telemetry.update();
//        }
//        axis1Left.setPower(0);
//        axis1Right.setPower(0);
//        axis2Left.setPower(0);
//        axis2Right.setPower(0);
//    }
//}

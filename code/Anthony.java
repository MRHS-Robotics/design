//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//@TeleOp (name = "Anthony")
//public class Anthony extends OpMode{
//
//    private DcMotor leftBack;
//    private DcMotor rightBack;
//
//    @Override
//    public void init() {
//        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
//        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
//    }
//
//    @Override
//    public void loop() {
//        leftBack.setPower(gamepad1.left_stick_y);
//        rightBack.setPower(gamepad1.right_stick_y);
//    }
//}

//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//@TeleOp (name = "SquareSpaceIsAlive")
//public class SquareSpaceIsAlive extends OpMode
//{
//    private DcMotor leftLegement;
//    private DcMotor rightLegement;
//
//    @Override
//    public void init()
//    {
//        leftLegement = hardwareMap.get(DcMotor.class, "leftLegement");
//        rightLegement = hardwareMap.get(DcMotor.class, "rightLegement");
//    }
//
//    @Override
//    public void loop ()
//    {
//        leftLegement.setPower(gamepad1.left_stick_y);
//        rightLegement.setPower(gamepad1.right_stick_y);
//    }
//}

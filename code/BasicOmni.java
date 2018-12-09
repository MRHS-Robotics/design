package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Basic Omni-bot")
public class BasicOmni extends OpMode {
    private DcMotor axis1Left;
    private DcMotor axis1Right;
    private DcMotor axis2Left;
    private DcMotor axis2Right;

    @Override
    public void init() {
        axis1Left = hardwareMap.get(DcMotor.class, "axis1 Left");
        axis1Right = hardwareMap.get(DcMotor.class, "axis1 Right");
        axis2Left = hardwareMap.get(DcMotor.class, "axis2 Left");
        axis2Right = hardwareMap.get(DcMotor.class, "axis2 Right");

    }

    @Override
    public void loop() {

        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;

        // choose a dominant axis and zero the other
        if (Math.abs(x) > Math.abs(y)) {
            y = 0.0d;
        } else {
            x = 0.0d;
        }

        axis1Left.setPower(-(y - x));
        axis1Right.setPower(y - x);

        axis2Left.setPower(y + x);
        axis2Right.setPower(-(y + x));

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

    }
}

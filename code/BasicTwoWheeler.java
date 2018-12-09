package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "Basic Two Wheeler")
public class BasicTwoWheeler extends OpMode{

    private DcMotor leftBack;
    private DcMotor rightBack;

    @Override
    public void init() {
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
    }

    @Override
    public void loop() {

        leftBack.setPower(gamepad1.left_stick_y);
        rightBack.setPower(-gamepad1.right_stick_y);

        if (gamepad1.right_bumper){
            leftBack.setPower(-1);
            rightBack.setPower(1);
        }
        else if (gamepad1.left_bumper){
            leftBack.setPower(1);
            rightBack.setPower(-1);
        }
    }
}

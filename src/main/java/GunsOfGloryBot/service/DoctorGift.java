package GunsOfGloryBot.service;

import java.awt.*;

public class DoctorGift {
    public void getDoctorGiftInCase() throws AWTException {
        Robot robot = new Robot();
        MouseActions mouse = new MouseActions();
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(171,371); //click get gift
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(226,480); // get gift
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);

        robot.mouseMove(205,461); //or exit if no gift
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
    }
}

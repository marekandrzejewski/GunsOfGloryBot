package GunsOfGloryBot.service;

import java.awt.*;
import java.awt.event.InputEvent;

public class ScreenMovements {
    Robot robot = new Robot();


    public ScreenMovements() throws AWTException {
    }

    public void academyMoveRight() {

        robot.mouseMove(300, 600);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(1159, 600);
        robot.delay(2000);
        robot.mouseMove(300, 600);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(300, 600);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(1100, 600);
        robot.delay(2000);
        robot.mouseMove(300, 600);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void cityMoveToTents() {
        //go down
        for (int i = 0; i < 2; i++) {
            dragAndDropDown();
        }
        //go right
        for (int i = 0; i < 4; i++) {
            academyMoveRight();
        }
        //go a bit left
        //52, 526 from this
        //to this
        //367,531
        robot.mouseMove(367, 526);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(37, 526);
        robot.delay(2000);
        robot.mouseMove(367, 526);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

    public void dragAndDropDown() {
        for (int i = 0; i < 1; i++) {
            robot.mouseMove(414, 171);
            robot.delay(2000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(414, 607);
            robot.delay(2000);
            robot.mouseMove(414, 171);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public void previewOfLowerCityBuildings() {
        for (int i = 0; i < 5; i++) {
            robot.delay(2000);
            robot.mouseMove(1110, 530);
            robot.delay(3000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(364, 153);
            robot.delay(2000);
            robot.mouseMove(1110, 530);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(2000);
        }
        dragAndDropDown();

        robot.delay(2000);
        robot.mouseMove(338, 582);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(700, 582);
        robot.delay(2000);
        robot.mouseMove(338, 582);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
    }
    public void previewOfUpperCityBuildings(){
        for (int i = 0; i < 5; i++) {
            robot.delay(2000);
            robot.mouseMove(1110, 530);
            robot.delay(3000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(364, 153);
            robot.delay(2000);
            robot.mouseMove(1110, 530);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(2000);
        }
        robot.mouseMove(300, 600);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(1159, 600);
        robot.delay(2000);
        robot.mouseMove(300, 600);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(644, 314);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(776, 539);
        robot.delay(2000);
        robot.mouseMove(644, 314);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public void dragAndDropUpLeftMenu(){
        for (int i = 0; i < 3; i++) {
            robot.mouseMove(413, 581);
            robot.delay(2000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(413, 254);
            robot.delay(2000);
            robot.mouseMove(413, 581);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }
    public void donationScrollUp(){
        for (int i = 0; i < 8; i++) {
            robot.mouseMove(230, 450);
            robot.delay(2000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(230, 380);
            robot.delay(2000);
            robot.mouseMove(230, 450);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }
    public void donationScrollDownToSkip3Donations(){
        robot.mouseMove(230, 380);
        robot.delay(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(230, 545);
        robot.delay(2000);
        robot.mouseMove(230, 380);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}

package GunsOfGloryBot.service;

import java.awt.*;
import java.awt.event.InputEvent;

public class ScreenMovements {
    Robot robot = new Robot();


    public ScreenMovements() throws AWTException {
    }

    public void academyMoveRight() {

        robot.mouseMove(19, 464);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(359, 464);
        robot.delay(2000);
        robot.mouseMove(19, 464);
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
        for (int i = 0; i < 2; i++) {
            robot.mouseMove(100, 367);
            robot.delay(2000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(100, 524);
            robot.delay(2000);
            robot.mouseMove(100, 367);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public void previewOfLowerCityBuildings() {
        for (int i = 0; i < 4; i++) {
            robot.delay(2000);
            robot.mouseMove(400, 542);
            robot.delay(3000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(50, 316);
            robot.delay(2000);
            robot.mouseMove(400, 542);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(2000);
        }
        dragAndDropDown();

        robot.delay(2000);
        robot.mouseMove(231, 439);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(387, 362);
        robot.delay(2000);
        robot.mouseMove(231, 439);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
    }
    public void dragAndDropUpLeftMenu(){
        for (int i = 0; i < 3; i++) {
            robot.mouseMove(90, 524);
            robot.delay(2000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(100, 367);
            robot.delay(2000);
            robot.mouseMove(90, 524);
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

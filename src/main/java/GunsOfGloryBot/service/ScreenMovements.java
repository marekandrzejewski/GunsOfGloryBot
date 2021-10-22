package GunsOfGloryBot.service;

import java.awt.*;
import java.awt.event.InputEvent;

public class ScreenMovements {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();

    public ScreenMovements() throws AWTException {
    }

    public void academyMoveRight(){

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
    public void cityMoveToTents(){
        //go down
        for (int i = 0; i < 2; i++){
            dragAndDropDownLeftMenu();
        }
        //go right
        for (int i = 0; i < 4; i++){
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
    public void dragAndDropDownLeftMenu(){
        for (int i = 0; i < 3; i++) {
            robot.mouseMove(100,367);
            robot.delay(2000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseMove(90, 524);
            robot.delay(2000);
            robot.mouseMove(100, 367);
            robot.delay(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }

    }
}

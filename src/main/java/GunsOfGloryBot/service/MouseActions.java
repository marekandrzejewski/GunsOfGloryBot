package GunsOfGloryBot.service;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MouseActions {
    Robot robot = new Robot();

    public MouseActions() throws AWTException {
    }

    public void click(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void goToBarracks(){
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        click();
        robot.delay(2000);
        robot.mouseMove(171,433);
        robot.delay(2000);
        click();
        robot.delay(2000);
    }
    public void gotoStables(){
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        click();
        robot.delay(2000);
        robot.mouseMove(171,454);
        robot.delay(2000);
        click();
        robot.delay(2000);

    }
    public void gotoShooters(){
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        click();
        robot.delay(2000);
        robot.mouseMove(171,475);
        robot.delay(2000);
        click();
        robot.delay(2000);

    }
    public void gotoArtillery(){
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        click();
        robot.delay(2000);
        robot.mouseMove(171,498);
        robot.delay(2000);
        click();
        robot.delay(2000);
    }
    public void closeResearchInnerScreen(){
        robot.delay(2000);
        robot.mouseMove(353,342); //379/325
        robot.delay(2000);
        click();
        robot.delay(2000);
    }
    public void goToKingdomOrReturnCity(){
        robot.delay(2000);
        robot.mouseMove(429,571);
        robot.delay(2000);
        click();
        robot.delay(2000);
    }
    public void clickSearchInKingdomScreen() {
        robot.mouseMove(81,505); //click search monsters or food
        robot.delay(2000);
        click();
        robot.delay(2000);
    }
    public void goToSearch(){
        robot.delay(2000);
        robot.mouseMove(53,551);
        robot.delay(2000);
        click();
        robot.delay(2000);
    }
}

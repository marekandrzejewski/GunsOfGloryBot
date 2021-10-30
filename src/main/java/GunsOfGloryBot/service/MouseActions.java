package GunsOfGloryBot.service;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MouseActions {
    Robot robot = new Robot();
    ScreenMovements screenMovements = new ScreenMovements();
    public MouseActions() throws AWTException {
    }

    public void click(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public void moveToPointAndClick(int x, int y){
        robot.delay(2000);
        robot.mouseMove(x,y);
        robot.delay(2000);
        click();
        robot.delay(2000);
    }
    public void goToBarracks(){
        moveToPointAndClick(255,400);
        moveToPointAndClick(255,400);
        screenMovements.dragAndDropUpLeftMenu();
        moveToPointAndClick(564,393);
    }
    public void gotoStables(){
        moveToPointAndClick(255,400);
        moveToPointAndClick(255,400);
        screenMovements.dragAndDropUpLeftMenu();
        moveToPointAndClick(564,434);

    }
    public void gotoShooters(){
        moveToPointAndClick(255,400);
        moveToPointAndClick(255,400);
        screenMovements.dragAndDropUpLeftMenu();
        moveToPointAndClick(564,477);

    }
    public void gotoArtillery(){
        moveToPointAndClick(255,400);
        moveToPointAndClick(255,400);
        screenMovements.dragAndDropUpLeftMenu();
        moveToPointAndClick(564,516);
    }
    public void closeResearchInnerScreen(){
        moveToPointAndClick(940,204);
    }
    public void closeAcademyScreen(){
        moveToPointAndClick(1086,76);
    }
    public void goToKingdomOrReturnCity(){
        moveToPointAndClick(1075,656);
    }
    public void clickSearchInKingdomScreen() {
        moveToPointAndClick(400,527);
    }
    public void goToSearch(){
        moveToPointAndClick(343,624);
    }
}

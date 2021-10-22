package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.ScreenMovements;

import java.awt.*;
import java.awt.event.InputEvent;

public class Research {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    ScreenMovements screenMovements = new ScreenMovements();
    public Research() throws AWTException {
    }

    public void goToAcademyAndResearch() {
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        screenMovements.dragAndDropDownLeftMenu();
        robot.delay(2000);
        robot.mouseMove(163,369);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(220,420);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(260,453);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
    }
    public void pickGeneralCategory(){
        robot.mouseMove(230,379);
        robot.delay(2500);
        mouse.click();
        robot.delay(2000);
    }
    public void pickDevelopCategory(){
        robot.mouseMove(286,379);
        robot.delay(2500);
        mouse.click();
        robot.delay(2000);
    }
    public void pickFightCategory(){
        robot.mouseMove(230,471);
        robot.delay(2500);
        mouse.click();
        robot.delay(2000);
    }
}

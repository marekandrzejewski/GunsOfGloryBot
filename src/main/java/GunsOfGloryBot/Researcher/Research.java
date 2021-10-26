package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.service.*;

import java.awt.*;

public class Research {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    ScreenMovements screenMovements = new ScreenMovements();

    public Research() throws AWTException {
    }

    public void goToAcademyAndResearch() throws AWTException {
     screenMovements.previewOfLowerCityBuildings();
     toTheAcademyAndClickResearch();
    }

    private void toTheAcademyAndClickResearch() {
        robot.delay(2000);
        robot.mouseMove(423,481);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(423,461); //klik badania
        robot.delay(2000);
        mouse.click();
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



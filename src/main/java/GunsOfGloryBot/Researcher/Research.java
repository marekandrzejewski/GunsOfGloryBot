package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.service.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Research {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    ScreenMovements screenMovements = new ScreenMovements();
    public Research() throws AWTException {
    }

    public void goToAcademyAndResearch() throws AWTException {
        String isResearching = "C:\\Users\\Admin\\Desktop\\goggraphics\\ifisresearching3.png";
        BotInterface botInterface = new BotInterface();
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        screenMovements.dragAndDropDownLeftMenu();
        robot.delay(2000);
        if (!ImageOnScreen.isOnScreen(isResearching)){
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.delay(1000);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            robot.delay(1000);
            botInterface.isResearching = true;
        }
        else{
            getResearchCoordsInLeftMenuAndMoveToIt();
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
    public void getResearchCoordsInLeftMenuAndMoveToIt(){
        ImageSearch imageSearch = new ImageSearch();
        System.out.println("wywołujemy współrzędne dla baraków");
        CoordData coordData = new CoordData(

                (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\ifisresearching3.png"))[0],
                (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\ifisresearching3.png"))[1]

        );

        robot.delay(2000);
        robot.mouseMove(coordData.getCoordX(),coordData.getCoordY());

    }
}

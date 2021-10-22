package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.ScreenMovements;

import java.awt.*;

public class PickPointAndClick {
    boolean isInitialized = false;
    Robot robot = new Robot();
    ScreenMovements screenMovements = new ScreenMovements();
    MouseActions mouse = new MouseActions();
    String researching = "C:\\Users\\Admin\\Desktop\\goggraphics\\researching.png";

    //beginning from UP LEFT
    int baseX = 23;
    int baseY = 359;
    int accidentCounter = 0;

    public PickPointAndClick() throws AWTException {
    }
            // TOP FIRST 23,359   x+90 to next
            // MIDDLE FIRST 23, 423 y+64 to next
            // BOTTOM FIRST 23, 487

    public boolean checkIfResearchAvaiable(){
        return ImageOnScreen.isOnScreen(researching);
    }
    public void initializeResearch(){
        robot.mouseMove(335,507);
        robot.delay(2500);
        mouse.click();
        robot.delay(2500);
        robot.mouseMove(433,274);
        robot.delay(2500);
        mouse.click();
        robot.delay(2500);
    }

    public void pickTopAndClick(){
        if (baseX > 443) {
            baseX = 23;
            screenMovements.academyMoveRight();
        }

                robot.delay(2500);
                robot.mouseMove(baseX,baseY); //top
                robot.delay(2500);
                mouse.click();
                robot.delay(2500);
        if (checkIfResearchAvaiable() || accidentCounter > 20){
            baseX = 23;
            accidentCounter = 0;
           initializeResearch();
           isInitialized = true;
           //order list. next order
        }
        else {
            mouse.closeResearchInnerScreen();
            accidentCounter++;
            pickMiddleAndClick();
        }
    }
    public void pickMiddleAndClick(){

        //pick a point and click
        robot.delay(2500);
        robot.mouseMove(baseX,baseY + 64); //middle
        robot.delay(2500);
        mouse.click();
        robot.delay(2500);
        if (checkIfResearchAvaiable()){
            baseX = 23;
            accidentCounter = 0;
            initializeResearch();
            isInitialized = true;

        }
        else {
            mouse.closeResearchInnerScreen();
            accidentCounter++;
            pickBottomAndClick();
        }
    }

    public void pickBottomAndClick(){

        //pick a point and click
        robot.delay(2500);
        robot.mouseMove(baseX,baseY + 128); //bottom
        robot.delay(2500);
        mouse.click();
        robot.delay(2500);

        if (checkIfResearchAvaiable()){
            baseX = 23;
            accidentCounter = 0;
            initializeResearch();
            isInitialized = true;
        }
        else {
            baseX = baseX + 90;
            mouse.closeResearchInnerScreen();
            accidentCounter++;
            pickTopAndClick();
        }

    }


}

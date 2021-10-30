package GunsOfGloryBot.Farmer;


import GunsOfGloryBot.service.ImageOnScreen;

import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.Strings;

import java.awt.*;

public class FarmWood {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    Strings strings = new Strings();
    public static int searchXpoint = FarmFood.foodSearchXpoint + 110;
    public static int searchYpoint = FarmFood.foodSearchYpoint;


    public FarmWood() throws AWTException {
    }

    public void woodInit() throws AWTException {
        mouse.moveToPointAndClick(FarmFood.foodXpoint + 120, FarmFood.foodYpoint); // click wood
        robot.mouseMove(838,458); // click + to increase farm level
        robot.delay(2000);
        for (int i = 0; i < 6; i++){
            mouse.click();
            robot.delay(2000);
        }
        robot.mouseMove(searchXpoint, searchYpoint);
        robot.delay(2000);
        mouse.click(); // click search
        condition();
    }

    private void condition() throws AWTException {
        if (strings.isTileInvalid()){
            lowerFarmLevelAndTryAgain();
        }
        else{
            mouse.moveToPointAndClick(680,378); // move to middle screen
            mouse.moveToPointAndClick(778,376); // occupy
            strings.checkIfMarchAvaiableAndClick();
            if (Strings.marches == 0)
            woodInit();// try again if not succeed
        }
    }

    public void lowerFarmLevelAndTryAgain() throws AWTException {
        mouse.moveToPointAndClick(637,458);
        mouse.moveToPointAndClick(searchXpoint,searchYpoint);
        condition();
    }
}


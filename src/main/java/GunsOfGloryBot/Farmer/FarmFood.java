package GunsOfGloryBot.Farmer;


import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.Strings;

import java.awt.*;

public class FarmFood {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    Strings strings = new Strings();
    public static int foodSearchXpoint = 628;
    public static int foodSearchYpoint = 528;
    public static int foodXpoint = 622;
    public static int foodYpoint = 633;


    public FarmFood() throws AWTException {
    }


    public void farmInit() throws AWTException {
        mouse.moveToPointAndClick(foodXpoint,foodYpoint);
        robot.mouseMove(721,458); // click + to increase farm level
        robot.delay(2000);
        for (int i = 0; i < 6; i++){
            mouse.click();
            robot.delay(2000);
        }

        mouse.moveToPointAndClick(foodSearchXpoint, foodSearchYpoint);
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
            farmInit(); // try again once if not succeed
        }
    }

    public void lowerFarmLevelAndTryAgain() throws AWTException {
        mouse.moveToPointAndClick(525,455);
        mouse.moveToPointAndClick(foodSearchXpoint,foodSearchYpoint);
        condition();
    }
}

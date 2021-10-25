package GunsOfGloryBot.Farmer;


import GunsOfGloryBot.service.ImageOnScreen;

import GunsOfGloryBot.service.MouseActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FarmFood {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    String invalidTileLevel = "C:\\Users\\Admin\\Desktop\\goggraphics\\invalidtilelevel.png";
    int searchXpoint = 200;
    int searchYpoint = 504;

    public FarmFood() throws AWTException {
    }
    public boolean isTileInvalid(){
        return ImageOnScreen.isOnScreen(invalidTileLevel);
    }

    public void farmInit() {



        robot.delay(2000);
        robot.mouseMove(193,559); //click Food
        robot.delay(2000);
        mouse.click();
        robot.mouseMove(245,467); // click + to increase farm level
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

    private void condition() {
        if (isTileInvalid()){
            lowerFarmLevelAndTryAgain();
        }
        else{

            robot.delay(2000);
            robot.mouseMove(227, 430); // move to middle screen
            robot.delay(2000);
            mouse.click(); // click on tile
            robot.delay(2000);
            robot.mouseMove(300, 430); // move to occupy
            robot.delay(2000);
            mouse.click(); // click on occupy
            robot.mouseMove(360,530);
            robot.delay(2000);
            mouse.click();//click march
            robot.delay(2000);

        }
    }

    public void lowerFarmLevelAndTryAgain(){
        robot.mouseMove(144,467); // move to - point
        robot.delay(2000);
        mouse.click(); // lower farm level by 1 and try again
        robot.delay(2000);
        robot.mouseMove(searchXpoint, searchYpoint);
        robot.delay(2000);
        mouse.click(); // click search
        robot.delay(2000);
        condition();
    }
}

package GunsOfGloryBot.CityBuilder;

import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.ScreenMovements;

import java.awt.*;

public class TentMaker extends Thread{
    String buildInProgress = "C:\\Users\\Admin\\Desktop\\goggraphics\\buildinprogress.png";
    String notEnoughCastle = "C:\\Users\\Admin\\Desktop\\goggraphics\\notenoughcastle.png";
    String buildable = "C:\\Users\\Admin\\Desktop\\goggraphics\\buildable.png";


    public boolean isBuilding(){
    return ImageOnScreen.isOnScreen(buildInProgress);
}

public boolean isCastleEnough(){
    return ImageOnScreen.isOnScreen(notEnoughCastle);
}
public boolean isBuildable(){
        return ImageOnScreen.isOnScreen(buildable);
}


    ScreenMovements screenMovements = new ScreenMovements();
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    public TentMaker() throws AWTException {
    }
        // TODO ADD 2 MORE TENTS LATER
    public void tentMakerInitialize(){
        screenMovements.cityMoveToTents();
        tent1();
        tent2();
        tent3();
        tent4();
        tent5();
        tent6();
    }
    public void tent1(){
        robot.delay(2000);
        robot.mouseMove(46,438);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(62,494);
        if (!isCastleEnough())
        buildTent();
        else {
            close();
        }
    }
    // 31,438    108,485        379,387
    //83, 441     152,453       429,412
    public void tent2(){
        robot.delay(2000);
        robot.mouseMove(83,431);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(112,469);
        if (!isCastleEnough())
            buildTent();
        else {
            close();
        }
    }
    public void tent3(){
        robot.delay(2000);
        robot.mouseMove(108,475);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(137,514);
        if (!isCastleEnough())
            buildTent();
        else {
            close();
        }
    }
    public void tent4(){
        robot.delay(2000);
        robot.mouseMove(152,443);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(181,483);
        if (!isCastleEnough())
            buildTent();
        else {
            close();
        }
    }
    public void tent5(){
        robot.delay(2000);
        robot.mouseMove(379,377);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(406,416);
        if (!isCastleEnough())
            buildTent();
        else {
           close();
        }
    }
    public void tent6(){
        robot.delay(2000);
        robot.mouseMove(429,392);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(424,439);
        if (!isCastleEnough())
            buildTent();
        else {
           close();
        }
    }

    public void buildTent() {
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        if (isBuildable()){
            robot.mouseMove(385,528);
            robot.delay(2000);
            mouse.click();
            robot.delay(2000);
            if (isBuilding()){
                robot.delay(2000);
                robot.mouseMove(373,326);
                robot.delay(2000);
                mouse.click();
                robot.delay(2000);
                robot.mouseMove(436,275);
                robot.delay(2000);
                mouse.click();
                robot.delay(2000);
            }
        } else close();
    }
    public void close(){
        robot.delay(1500);
        robot.mouseMove(438,273);
        robot.delay(1500);
        mouse.click();
    }
}

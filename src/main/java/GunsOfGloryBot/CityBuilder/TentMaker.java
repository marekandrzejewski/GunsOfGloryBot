package GunsOfGloryBot.CityBuilder;

import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.ScreenMovements;
import GunsOfGloryBot.service.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TentMaker extends Thread{
    String buildInProgress = "C:\\Users\\Admin\\Desktop\\goggraphics\\buildinprogress.png";
    String notEnoughCastle = "C:\\Users\\Admin\\Desktop\\goggraphics\\notenoughcastle.png";
    String buildable = "C:\\Users\\Admin\\Desktop\\goggraphics\\buildable.png";
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
        }
    });
    int second = 0;
    int buildCounter = 0;

    public int getSecond() {
        return second;
    }

    public TentMaker setSecond(int second) {
        this.second = second;
        return this;
    }

    @Override
    public void run() {
timer.start();
    }

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
    public void tentMakerInitialize() throws AWTException {
        BotInterface botInterface = new BotInterface();
        if (ImageOnScreen.isOnScreen(Strings.mapa)){
            mouse.goToKingdomOrReturnCity();            // if we are out of city
        }
        if (getSecond() > 3600){
        if (buildCounter < 2) { // unable to act if both tents are already building

            TrainArmy trainArmy = new TrainArmy();
            Farm farm = new Farm();
            AttackMonsters attackMonsters = new AttackMonsters();
            ResearchInitialize researchInitialize = new ResearchInitialize();
            System.out.println("wykonujemy NAMIOTY, minęło 120 sekund");
            botInterface.isMakingOrders = true;
            trainArmy.setSecond(trainArmy.getSecond() - 60);
            farm.setSecond(farm.getSecond() - 60);
            attackMonsters.setSecond(attackMonsters.getSecond() - 60);
            researchInitialize.setSecond(researchInitialize.getSecond() - 60);

            screenMovements.cityMoveToTents();
            if (buildCounter < 2) tent1();
            if (buildCounter < 2) tent2();
            if (buildCounter < 2) tent3();
            if (buildCounter < 2) tent4();
            if (buildCounter < 2) tent5();
            if (buildCounter < 2) tent6();
        }
        else System.out.println("wszystkie sloty budowy zajęte!");
        } else System.out.println("czas budowy nie minął!");

        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz NAMIOTY");
        setSecond(0);
    }
    public void tent1(){
        robot.delay(2000);
        robot.mouseMove(46,453);
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
            buildCounter++;
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

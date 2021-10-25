package GunsOfGloryBot.MonsterAttacker;

import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.RemoteServer;

public class AttackMonsters extends Thread{

    //TODO GOTOWE ALE ZROBIONE NA 1 SLOT MARSZU, ZRÓB NA WIĘCEJ
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    String invalidMonsterLevel = "C:\\Users\\Admin\\Desktop\\goggraphics\\invalidmonsterlevel.png";
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
        }
    });
    int second = 0;

    public AttackMonsters() throws AWTException {
    }

    public int getSecond() {
        return second;
    }

    public AttackMonsters setSecond(int second) {
        this.second = second;
        return this;
    }

    @Override
    public void run() {
        timer.start();
    }

    public boolean isLevelInvalid(){
        return ImageOnScreen.isOnScreen(invalidMonsterLevel);
    }
    public void huntMonstersInitializer(int level) throws AWTException {
        ResearchInitialize researchInitialize = new ResearchInitialize();
        BotInterface botInterface = new BotInterface();
        TentMaker tentMaker = new TentMaker();
        Farm farm = new Farm();
        TrainArmy trainArmy = new TrainArmy();
        System.out.println("wykonujemy rozkaz ATAKUJ MOBKI, minęło 55 minut");
        botInterface.isMakingOrders = true;
        researchInitialize.setSecond(researchInitialize.getSecond() - 120);
        tentMaker.setSecond(tentMaker.getSecond() - 120);
        farm.setSecond(farm.getSecond() - 120);
        trainArmy.setSecond(trainArmy.getSecond() - 120);

        if (!ImageOnScreen.isOnScreen(botInterface.mapa)){
            mouse.goToKingdomOrReturnCity();
        }

        mouse.goToSearch();
        robot.mouseMove(80,557); // click threats
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        setMonsterLevelAndSearchIt(level);
        attackMonsters();

        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz ATAKUJ MOBKI");
        setSecond(0);
    }
    public void attackMonsters(){
        robot.mouseMove(223,426); //click middle screen on monster
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(402,482); //click attack
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        if (isLevelInvalid()){
            lowerLevelByOneAndTryAgain();

        } else {
            robot.mouseMove(360,530); //click march
            robot.delay(2000);
            mouse.click();
            robot.delay(2000);
        }

    }
    public void setMonsterLevelAndSearchIt(int level){
        robot.delay(2000);
        robot.mouseMove(132,466); // click +
        robot.delay(2000);
        for (int i = 1; i <= level ; i++){
            mouse.click();
            robot.delay(2000);
        }
       mouse.clickSearchInKingdomScreen();
    }



    private void lowerLevelByOneAndTryAgain() {
        robot.mouseMove(29,468); //click - , lower level by one
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        mouse.clickSearchInKingdomScreen();
        attackMonsters(); //try again
    }
}

package GunsOfGloryBot.MonsterAttacker;

import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.Farmer.FarmFood;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AttackMonsters extends Thread{

    //TODO zweryfikuj czy jest atakowany ten sam mob przez dwie armie
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    Strings strings = new Strings();
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


    public void huntMonstersInitializer(int level) throws AWTException {
        ResearchInitialize researchInitialize = new ResearchInitialize();
        BotInterface botInterface = new BotInterface();
        TentMaker tentMaker = new TentMaker();
        Farm farm = new Farm();
        TrainArmy trainArmy = new TrainArmy();
        System.out.println("wykonujemy rozkaz ATAKUJ MOBKI, minęło 55 minut");
        botInterface.isMakingOrders = true;
        //researchInitialize.setSecond(researchInitialize.getSecond() - 600);
        researchInitialize.timer.setDelay(1800000);
        //tentMaker.setSecond(tentMaker.getSecond() - 600);
        //farm.setSecond(farm.getSecond() - 600);
        farm.timer.setDelay(1800000);
        //trainArmy.setSecond(trainArmy.getSecond() - 600);
        trainArmy.timer.setDelay(1800000);

        if (!ImageOnScreen.isOnScreen(Strings.mapa) && ImageOnScreen.isOnScreen(strings.chickInCity)){
            mouse.goToKingdomOrReturnCity();
        }

        mouse.goToSearch();
        mouse.moveToPointAndClick(FarmFood.foodXpoint - 240, FarmFood.foodYpoint);
        setMonsterLevelAndSearchIt(level);
        attackMonsters();

        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz ATAKUJ MOBKI");
        setSecond(0);
    }
    public void attackMonsters() throws AWTException {

        if (strings.isLevelInvalid()){
            lowerLevelByOneAndTryAgain();
        } else {
            mouse.moveToPointAndClick(677,375);  //click middle screen on monster
            //strings.checkIfAttackableAndClickAttack();
            mouse.moveToPointAndClick(1102,496);
            strings.checkIfMarchAvaiableAndClick();
        }

    }
    public void setMonsterLevelAndSearchIt(int level){
        robot.delay(2000);
        robot.mouseMove(495,449); // click +
        robot.delay(2000);
        for (int i = 1; i <= level ; i++){
            mouse.click();
            robot.delay(2000);
        }
       mouse.clickSearchInKingdomScreen();
    }
    public void lowerLevelByOneAndTryAgain() throws AWTException {
       mouse.moveToPointAndClick(300,453); //click -
        mouse.clickSearchInKingdomScreen();
        attackMonsters(); //try again
    }
}

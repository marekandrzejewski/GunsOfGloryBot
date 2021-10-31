package GunsOfGloryBot.service;

import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.ResearchInitialize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DoctorGift extends Thread {
    ScreenMovements screenMovements = new ScreenMovements();
    Robot robot = new Robot();
    int second = 0;
    public Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
        }
    });

    public int getSecond() {
        return second;
    }

    public DoctorGift setSecond(int second) {
        this.second = second;
        return this;
    }

    public DoctorGift() throws AWTException {
    }

    @Override
    public void run() {
        timer.start();
    }

    public void getDoctorGiftInCase() throws AWTException {
        BotInterface botInterface = new BotInterface();
        ResearchInitialize researchInitialize = new ResearchInitialize();
        TentMaker tentMaker = new TentMaker();
        Farm farm = new Farm();
        TrainArmy trainArmy = new TrainArmy();
        AttackMonsters attackMonsters = new AttackMonsters();
        System.out.println("wykonujemy rozkaz DOC, minęła minutka");
        botInterface.isMakingOrders = true;
        tentMaker.setSecond(tentMaker.getSecond() - 60);
        farm.setSecond(farm.getSecond() - 60);
        attackMonsters.setSecond(attackMonsters.getSecond() - 60);
        researchInitialize.setSecond(researchInitialize.getSecond() - 60);
        trainArmy.setSecond(trainArmy.getSecond() - 60);
        MouseActions mouse = new MouseActions();
        Strings strings = new Strings();
        mouse.moveToPointAndClick(255,400);
        mouse.moveToPointAndClick(255,400);
        screenMovements.dragAndDropUpLeftMenu();
        mouse.moveToPointAndClick(562,265); //click get gift
        strings.checkIfCollectableAndClick();
        strings.checkIfCollectableAndClick();   // doc OR gift !!!
        strings.accidentServiceForCityActionsIfBotFroze();
        robot.delay(5000);
        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz DOC");
        setSecond(0);
    }
}

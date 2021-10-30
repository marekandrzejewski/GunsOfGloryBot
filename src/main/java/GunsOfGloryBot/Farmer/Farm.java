package GunsOfGloryBot.Farmer;

import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Farm extends Thread{
    FarmFood farmFood = new FarmFood();
    FarmWood farmWood = new FarmWood();
    FarmIron farmIron = new FarmIron();
    FarmSilver farmSilver = new FarmSilver();
    FarmAlliance farmAlliance = new FarmAlliance();
    MouseActions mouse = new MouseActions();

    public Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
        }
    });
    int second = 0;

    public Farm() throws AWTException {
    }

    public int getSecond() {
        return second;
    }

    public Farm setSecond(int second) {
        this.second = second;
        return this;
    }

    @Override
    public void run() {
        timer.start();
    }

    public void farmFood() throws AWTException {
        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        TentMaker tentMaker = new TentMaker();
        AttackMonsters attackMonsters = new AttackMonsters();
        ResearchInitialize researchInitialize = new ResearchInitialize();
        System.out.println("wykonujemy ŻARCIE, minęło 120 sekund");
        botInterface.isMakingOrders = true;
        tentMaker.setSecond(tentMaker.getSecond() - 120);
        trainArmy.setSecond(trainArmy.getSecond() - 120);
        attackMonsters.setSecond(attackMonsters.getSecond() - 120);
        researchInitialize.setSecond(researchInitialize.getSecond() - 120);

        if (!ImageOnScreen.isOnScreen(Strings.mapa)){
            mouse.goToKingdomOrReturnCity();
        }
        mouse.goToSearch();
        farmFood.farmInit();

        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz FARM ŻARCIE");
        setSecond(0);
    }
    public void farmWood() throws AWTException {
        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        TentMaker tentMaker = new TentMaker();
        AttackMonsters attackMonsters = new AttackMonsters();
        ResearchInitialize researchInitialize = new ResearchInitialize();
        System.out.println("wykonujemy ŻARCIE, minęło 120 sekund");
        botInterface.isMakingOrders = true;
        tentMaker.setSecond(tentMaker.getSecond() - 120);
        trainArmy.setSecond(trainArmy.getSecond() - 120);
        attackMonsters.setSecond(attackMonsters.getSecond() - 120);
        researchInitialize.setSecond(researchInitialize.getSecond() - 120);

        if (!ImageOnScreen.isOnScreen(Strings.mapa)){
            mouse.goToKingdomOrReturnCity();
        }
        mouse.goToSearch();
        farmWood.woodInit();

        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz FARM DREWNO");
        setSecond(0);
    }
    public void farmIron(){
        mouse.goToKingdomOrReturnCity();
        mouse.goToSearch();
       // farmIron.farmInit();
    }
    public void farmSilver(){
        mouse.goToKingdomOrReturnCity();
        mouse.goToSearch();
      //  farmSilver.farmInit();
    }
}

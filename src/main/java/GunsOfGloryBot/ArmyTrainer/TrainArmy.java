package GunsOfGloryBot.ArmyTrainer;

import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainArmy extends Thread{
    int second = 0;

    ScreenMovements screenMovements = new ScreenMovements();
    ResearchInitialize researchInitialize = new ResearchInitialize();
    public Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
        }
    });

    public int getSecond() {
        return second;
    }

    public TrainArmy setSecond(int second) {
        this.second = second;
        return this;
    }


    @Override
    public void run(){
        timer.start();
    }


    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    DoctorGift doctorGift = new DoctorGift();
    Strings strings = new Strings();
    public TrainArmy() throws AWTException {
    }

    public void armyTrain() throws AWTException, InterruptedException {
        BotInterface botInterface = new BotInterface();
        TentMaker tentMaker = new TentMaker();
        Farm farm = new Farm();
        AttackMonsters attackMonsters = new AttackMonsters();
        System.out.println("wykonujemy rozkaz TRENUJ ARMIĘ, minęło 55 minut");
        botInterface.isMakingOrders = true;
        tentMaker.setSecond(tentMaker.getSecond() - 60);
        farm.setSecond(farm.getSecond() - 60);
        attackMonsters.setSecond(attackMonsters.getSecond() - 60);
        researchInitialize.setSecond(researchInitialize.getSecond() - 60);
        if (ImageOnScreen.isOnScreen(Strings.mapa)){
            mouse.goToKingdomOrReturnCity();            // if we are out of city
        }

        doctorGift.getDoctorGiftInCase();
        doctorGift.getDoctorGiftInCase();
        //barracks
        mouse.goToBarracks();
        clickTrainAndReturn();
        doctorGift.getDoctorGiftInCase();
        doctorGift.getDoctorGiftInCase();
        // stables
        mouse.gotoStables();
        clickTrainAndReturn();
        doctorGift.getDoctorGiftInCase();
        doctorGift.getDoctorGiftInCase();
        // artillery
          mouse.gotoArtillery();
       clickTrainAndReturn();
        doctorGift.getDoctorGiftInCase();
        doctorGift.getDoctorGiftInCase();
        // shooters
         mouse.gotoShooters();
        clickTrainAndReturn();

        robot.delay(5000);
//        System.out.println("usypiamy wątek TRENUJ ARMIE na 3 minuty na czas wykonywania rozkazu TRENUJ ARMIE");
//        Thread.sleep(180000); // 3 minuty
        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz TRENUJ ARMIĘ");
        setSecond(0);
    }
    public void clickTrainAndReturn(){
        mouse.moveToPointAndClick(741,404);
        strings.checkIfTrainableAndClick();
         //default train army, case enough resources
        //without option constant training, screen returns to city
    }

    public void armyMontage() {
        screenMovements.previewOfUpperCityBuildings();
        mouse.moveToPointAndClick(652,228);
        mouse.moveToPointAndClick(759,289);
        mouse.moveToPointAndClick(858,400);
        mouse.moveToPointAndClick(811,511);
    }
}

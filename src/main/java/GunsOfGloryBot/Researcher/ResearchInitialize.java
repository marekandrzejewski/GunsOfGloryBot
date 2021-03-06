package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResearchInitialize extends Thread{
    //TODO sprawdź czy przy próbie zamknięcia po nieznalezieniu napisu badaj kursor nie  trafi w szare badanie
    //TODO zwiększ dynamikę badań sprawdzając czy po kliknięciu akademia/badania nie wykonuje się już badanie. I zamknij
    int second = 0;
    public static int researchOrderCounter = 0;
    PickPointAndClick pickPointAndClick = new PickPointAndClick();
    Research research = new Research();
    MouseActions mouse = new MouseActions();
    Strings strings = new Strings();
    public Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
        }
    });

    public ResearchInitialize() throws AWTException {
    }

    @Override
    public void run(){
        timer.start();
    }

    public int getSecond() {
        return second;
    }

    public ResearchInitialize setSecond(int second) {
        this.second = second;
        return this;
    }




    public void researchGeneral() throws AWTException {
        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        TentMaker tentMaker = new TentMaker();
        Farm farm = new Farm();
        AttackMonsters attackMonsters = new AttackMonsters();

        System.out.println("wykonujemy badanie General, minęło 900 sekund");
        botInterface.isMakingOrders = true;
        trainArmy.setSecond(trainArmy.getSecond() - 60);
        tentMaker.setSecond(tentMaker.getSecond() - 60);
        farm.setSecond(farm.getSecond() - 60);
        attackMonsters.setSecond(attackMonsters.getSecond() - 60);
        research.goToAcademyAndResearch();


        //repeatable, now to general
         research.pickGeneralCategory();

        //pick a point and click
        pickPointAndClick.pickTopAndClick();

        //System.out.println("usypiamy wątek BADANIA GENERAL na 5 minut na czas wykonywania BADAŃ");
       // Thread.sleep(300000); usypianie w tym przypadku niepotrzebne
        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz BADANIA GENERAL");
        setSecond(0);
    }

    public void researchDevelop() throws AWTException {
        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        System.out.println("wykonujemy badanie Develop, minęło 300 sekund");
        botInterface.isMakingOrders = true;
        trainArmy.setSecond(trainArmy.getSecond() - 60);

        if (ImageOnScreen.isOnScreen(Strings.mapa)){
            mouse.goToKingdomOrReturnCity();            // if we are out of city
        }

        research.goToAcademyAndResearch();

        if (!ImageOnScreen.isOnScreen(strings.isResearching1) && ImageOnScreen.isOnScreen(strings.fragmentAkademii)){
            System.out.println("nie ma badań, wykonujemy rozkaz BADANIA");
            //repeatable, now to general
            research.pickDevelopCategory();

            //pick a point and click
            pickPointAndClick.pickTopAndClick();
        } else if (ImageOnScreen.isOnScreen(strings.isResearching1) && ImageOnScreen.isOnScreen(strings.fragmentAkademii)){
            System.out.println("badania się wykonują");
            mouse.closeAcademyScreen();
        }
        else {
            System.out.println("nie widać ekranu akademii, nie robimy nic");
        }

        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz BADANIA DEVELOP");
        setSecond(0);
    }
    public void researchArmy() throws AWTException, InterruptedException {

        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        AttackMonsters attackMonsters = new AttackMonsters();
        System.out.println("wykonujemy badanie ARMIA, minęło " + getSecond() / 3600 + " h " +
        (getSecond() % 3600) / 60 + " min " +
                (getSecond() % 3600) % 60 + " sek ");

        botInterface.isMakingOrders = true;
        trainArmy.setSecond(trainArmy.getSecond() - 120);
        attackMonsters.setSecond(attackMonsters.getSecond() - 120);
        strings.checkIfCloseXisAvaiableAndClick();

        if (strings.checkMapInKingdom() || strings.checkBookInKingdom() || strings.checkSearchInKingdom()){
            mouse.goToKingdomOrReturnCity();            // if we are out of city
        }
        strings.checkIfCloseXisAvaiableAndClick();
        strings.accidentServiceForCityActionsIfBotFroze();
        research.goToAcademyAndResearch();

        Thread.sleep(3000);

        if (strings.ifResearchInAcademyIsInProgress()){
            System.out.println("nie ma badań, wykonujemy rozkaz BADANIA");
            //repeatable, now to fight
            research.pickFightCategory();

            //pick a point and click
            pickPointAndClick.pickTopAndClick();
        }
        else {
            strings.checkIfAcademyIsBuildingWhileTryToResearch();
            strings.checkIfCloseXisAvaiableAndClick();
            System.out.println("nie widać ekranu akademii, nie robimy nic");
            trainArmy.setSecond(trainArmy.getSecond() + 20);
            attackMonsters.setSecond(attackMonsters.getSecond() + 20);
        }
        botInterface.isMakingOrders = false;
        System.out.println("wykonano rozkaz BADANIA ARMIA");
        setSecond(0);
        mouse.moveToPointAndClick(987,304); // ally help

    }
}

package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.service.MouseActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResearchInitialize extends Thread{
    //TODO sprawdź czy przy próbie zamknięcia po nieznalezieniu napisu badaj kursor nie  trafi w szare badanie
    //TODO zwiększ dynamikę badań sprawdzając czy po kliknięciu akademia/badania nie wykonuje się już badanie. I zamknij
    int second = 0;
    Timer timer = new Timer(1000, new ActionListener() {
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

    MouseActions mouse = new MouseActions();
    PickPointAndClick pickPointAndClick = new PickPointAndClick();
    Research research = new Research();





    public void researchGeneral() throws InterruptedException, AWTException {
        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        System.out.println("wykonujemy badanie General, minęło 900 sekund");
        botInterface.isMakingOrders = true;
        trainArmy.setSecond(trainArmy.getSecond() - 60);

        research.goToAcademyAndResearch();

        //repeatable, now to general
         research.pickGeneralCategory();

        //pick a point and click
        pickPointAndClick.pickTopAndClick();

        //System.out.println("usypiamy wątek BADANIA GENERAL na 5 minut na czas wykonywania BADAŃ");
       // Thread.sleep(300000); usypianie w tym przypadku niepotrzebne
        botInterface.isMakingOrders = false;
        System.out.println("wybudzamy wątek BADAŃ");
        setSecond(0);
    }

    public void researchDevelop() throws InterruptedException, AWTException {
        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        System.out.println("wykonujemy badanie Develop, minęło 900 sekund");
        botInterface.isMakingOrders = true;
        trainArmy.setSecond(trainArmy.getSecond() - 60);

        research.goToAcademyAndResearch();

        //repeatable, now to general
        research.pickDevelopCategory();

        //pick a point and click
        pickPointAndClick.pickTopAndClick();

        System.out.println("usypiamy wątek BADANIA DEVELOP na 5 minut na czas wykonywania BADAŃ");
        Thread.sleep(300000);
        botInterface.isMakingOrders = false;
        System.out.println("wybudzamy wątek BADAŃ");
        setSecond(0);
    }
    public void researchArmy() throws InterruptedException, AWTException {
        BotInterface botInterface = new BotInterface();
        TrainArmy trainArmy = new TrainArmy();
        System.out.println("wykonujemy badanie ARMIA, minęło 900 sekund");
        botInterface.isMakingOrders = true;
        trainArmy.setSecond(trainArmy.getSecond() - 60);

        research.goToAcademyAndResearch();

        //repeatable, now to general
        research.pickFightCategory();

        //pick a point and click
        pickPointAndClick.pickTopAndClick();

        System.out.println("usypiamy wątek BADANIA ARMIA na 5 minut na czas wykonywania BADAŃ");
        Thread.sleep(300000);
        botInterface.isMakingOrders = false;
        System.out.println("wybudzamy wątek BADAŃ");
        setSecond(0);
    }
}

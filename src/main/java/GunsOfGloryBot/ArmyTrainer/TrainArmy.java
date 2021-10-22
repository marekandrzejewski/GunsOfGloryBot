package GunsOfGloryBot.ArmyTrainer;

import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.DoctorGift;
import GunsOfGloryBot.service.MouseActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainArmy extends Thread{
    int second = 0;
    int minute = 0;
    int hour = 0;
    BotInterface botInterface;
    ResearchInitialize researchInitialize;
    Timer timer = new Timer(1000, new ActionListener() {
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

    public TrainArmy() throws AWTException {
    }

    public void armyTrain() throws AWTException, InterruptedException {

        System.out.println("wykonujemy rozkaz TRENUJ ARMIĘ, minęło 55 minut");
        botInterface.isMakingOrders = true;
        researchInitialize.setSecond(researchInitialize.getSecond() - 60);

        doctorGift.getDoctorGiftInCase();
        //barracks
        mouse.goToBarracks();
        clickTrainAndReturn();

        // stables
        mouse.gotoStables();
        clickTrainAndReturn();

        // artillery
          mouse.gotoArtillery();
       clickTrainAndReturn();

        // shooters
         mouse.gotoShooters();
        clickTrainAndReturn();

        robot.delay(5000);
        //TODO prawdopodobnie usypianie też w tym przypadku będzie niepotrzebne, nie tylko w przypadku badań bo mamy cofnięcie timerów
        System.out.println("usypiamy wątek TRENUJ ARMIE na 3 minuty na czas wykonywania rozkazu TRENUJ ARMIE");
        Thread.sleep(180000); // 3 minuty
        botInterface.isMakingOrders = false;
        System.out.println("wybudzamy wątek TRENUJ ARMIE");
        setSecond(0);
    }
    public void clickTrainAndReturn(){
        robot.mouseMove(252,441);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(400,533);
        robot.delay(2000);
        mouse.click(); //in this moment screen is on picking correct army
        robot.delay(2000);
         //default train army, case enough resources
        //without option constant training, screen returns to city
    }

}

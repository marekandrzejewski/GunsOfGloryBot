package GunsOfGloryBot.ArmyTrainer;

import GunsOfGloryBot.service.DoctorGift;
import GunsOfGloryBot.service.MouseActions;

import java.awt.*;

public class ArmyUpgrader extends Thread{
//TODO upgrader jest tylko zrobiony z 1 poziomu na 2!!!!
    @Override
    public void run(){
        try {
            armyTrain();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    DoctorGift doctorGift = new DoctorGift();

    public ArmyUpgrader() throws AWTException {
    }

    public void armyTrain() throws AWTException {

        doctorGift.getDoctorGiftInCase();
        //barracks
        mouse.goToBarracks();
        clickUpgradeAndReturn();

        // stables
        mouse.gotoStables();
        clickUpgradeAndReturn();

        // artillery
          mouse.gotoArtillery();
        clickUpgradeAndReturn();

        // shooters
         mouse.gotoShooters();
        clickUpgradeAndReturn();

        robot.delay(5000);
    }
    public void clickUpgradeAndReturn(){
        robot.mouseMove(252,441);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(55,373);
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

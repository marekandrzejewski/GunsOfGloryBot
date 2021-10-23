package GunsOfGloryBot;
import GunsOfGloryBot.ArmyTrainer.ArmyUpgrader;
import GunsOfGloryBot.ArmyTrainer.TrainArmy;

import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.*;

import java.awt.*;



public class BotInterface {
    public boolean isMakingOrders = false;
    public boolean isResearching = false;
    ResearchInitialize orderResearch = new ResearchInitialize();
    ImageSearch imageSearch = new ImageSearch();
    TrainArmy orderTrainArmy = new TrainArmy();
    Robot robot = new Robot();
    TentMaker orderTentMake = new TentMaker();
    Farm orderFarmer = new Farm();
    AttackMonsters orderAttackMonsters = new AttackMonsters();
    ArmyUpgrader orderArmyUpgrade = new ArmyUpgrader();


    public BotInterface() throws AWTException {
    }



        public void appRun() throws InterruptedException, AWTException {
            orderResearch.start();
            orderTrainArmy.start();
            //others

            while(true){
                System.out.print("Rozkaz BADANIA: " + orderResearch.getSecond() / 3600 + " h " +
                        (orderResearch.getSecond() % 3600) / 60 + " min " +
                        (orderResearch.getSecond() % 3600) % 60 + " sek ");
                System.out.print("Rozkaz TRENUJ ARMIĘ: " + orderTrainArmy.getSecond() / 3600 + " h " +
                        (orderTrainArmy.getSecond() % 3600) / 60 + " min " +
                        (orderTrainArmy.getSecond() % 3600) % 60 + " sek ");
                Thread.sleep(1000);
                System.out.println();

                if ((orderResearch.getSecond() >= 300 && !isMakingOrders && !isResearching)) { // 5 min
                    orderResearch.researchDevelop();
                    isResearching = false;
                }
                if (orderTrainArmy.getSecond() >= 3300 && !isMakingOrders) { // 55 min
                    orderTrainArmy.armyTrain();
                }
            }
        }


    String trainingInProgress = "C:\\Users\\Admin\\Desktop\\goggraphics\\trainingInProgress.png";
    String isResearching3 = "C:\\Users\\Admin\\Desktop\\goggraphics\\ifisresearching3.png";

    public void trainingInProgressTest(){
        System.out.println("metoda isonscreen");
        System.out.println(ImageOnScreen.isOnScreen(isResearching3));
    }

    public static void barracksCoords(){
        System.out.println("tutaj będą wywołane współrzędne obrazka");
       // System.out.println(Arrays.toString(ImageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\eloo.png")));
    }

    public void getExampleCoords(){
        System.out.println("wywołujemy współrzędne dla baraków");
        CoordData coordData = new CoordData(

                (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\ifisresearching3.png"))[0],
                (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\ifisresearching3.png"))[1]

                );

        System.out.println(coordData.getCoordX());
        System.out.println(coordData.getCoordY());
    }

}

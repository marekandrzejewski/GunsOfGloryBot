package GunsOfGloryBot;
import GunsOfGloryBot.ArmyTrainer.ArmyUpgrader;
import GunsOfGloryBot.ArmyTrainer.TrainArmy;

import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.*;

import java.awt.*;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BotInterface {
    public boolean isMakingOrders = false;
    ResearchInitialize orderResearch = new ResearchInitialize();
    TrainArmy orderTrainArmy = new TrainArmy();
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

                if (orderResearch.getSecond() >= 900 && !isMakingOrders) { // 15 min
                    orderResearch.researchDevelop();
                }
                if (orderTrainArmy.getSecond() >= 3300 && !isMakingOrders) { // 55 min
                    orderTrainArmy.armyTrain();
                }
            }
        }


    String trainingInProgress = "C:\\Users\\Admin\\Desktop\\goggraphics\\trainingInProgress.png";

    public void showTime(){

    }

    public void trainingInProgressTest(){
        System.out.println("metoda isonscreen");
        System.out.println(ImageOnScreen.isOnScreen(trainingInProgress));
    }

    public static void barracksCoords(){
        System.out.println("tutaj będą wywołane współrzędne obrazka");
       // System.out.println(Arrays.toString(ImageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\eloo.png")));
    }

    public void getBarracksCoords(){
        System.out.println("wywołujemy współrzędne dla baraków");
//        CoordData coordData = new CoordData(
//
//                (ImageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\barracksnapis2.png"))[0],
//                (ImageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\barracksnapis2.png"))[1]
//
//                );
//
//        System.out.println(coordData.getCoordX());
//        System.out.println(coordData.getCoordY());
    }

}

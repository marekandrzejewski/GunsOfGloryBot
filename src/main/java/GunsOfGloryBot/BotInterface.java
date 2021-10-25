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
    TentMaker orderTentMake = new TentMaker();
    Farm orderFarmer = new Farm();
    AttackMonsters orderAttackMonsters = new AttackMonsters();
    ArmyUpgrader orderArmyUpgrade = new ArmyUpgrader();


    public BotInterface() throws AWTException {
    }



        public void appRun() throws InterruptedException, AWTException {
            orderResearch.start();
            orderTrainArmy.start();
            orderTentMake.start();
            orderFarmer.start();
            orderAttackMonsters.start();
            //others

            while(true){
                System.out.print("BADANIA: " + orderResearch.getSecond() / 3600 + " h " +
                        (orderResearch.getSecond() % 3600) / 60 + " min " +
                        (orderResearch.getSecond() % 3600) % 60 + " sek ");
                System.out.print("TRENUJ ARMIĘ: " + orderTrainArmy.getSecond() / 3600 + " h " +
                        (orderTrainArmy.getSecond() % 3600) / 60 + " min " +
                        (orderTrainArmy.getSecond() % 3600) % 60 + " sek ");
                System.out.print("TENT: " + orderTentMake.getSecond() / 3600 + " h " +
                        (orderTentMake.getSecond() % 3600) / 60 + " min " +
                        (orderTentMake.getSecond() % 3600) % 60 + " sek ");
                System.out.print("FARM: " + orderFarmer.getSecond() / 3600 + " h " +
                        (orderFarmer.getSecond() % 3600) / 60 + " min " +
                        (orderFarmer.getSecond() % 3600) % 60 + " sek ");
                System.out.print("MOBS: " + orderAttackMonsters.getSecond() / 3600 + " h " +
                        (orderAttackMonsters.getSecond() % 3600) / 60 + " min " +
                        (orderAttackMonsters.getSecond() % 3600) % 60 + " sek ");
                Thread.sleep(1000);
                System.out.println();

                if ((orderResearch.getSecond() >= 999999 && !isMakingOrders && !isResearching)) { // wprowadź czas
                    orderResearch.researchArmy();
                    isResearching = false;
                }
                if (orderTrainArmy.getSecond() >= 3300 && !isMakingOrders) { // 55 min 3300 sek
                    orderTrainArmy.armyTrain();
                }
                if (orderTentMake.getSecond() >= 3600  && !isMakingOrders) { // PRZYKŁADOWO GODZINA, POPRAW
                    orderTentMake.tentMakerInitialize();
                }
                if (orderFarmer.getSecond() >= 30  && !isMakingOrders) { // 55 min 3300 sek
                    orderFarmer.farmFood();
                }
                if (orderAttackMonsters.getSecond() >= 40  && !isMakingOrders) { // 55 min 3300 sek
                    orderAttackMonsters.huntMonstersInitializer(3);
                }
            }
        }


    String trainingInProgress = "C:\\Users\\Admin\\Desktop\\goggraphics\\trainingInProgress.png";
    public String mapa = "C:\\Users\\Admin\\Desktop\\goggraphics\\mapa.png";

    public void trainingInProgressTest(){
        System.out.println("metoda isonscreen");
        System.out.println(ImageOnScreen.isOnScreen(mapa));
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

package GunsOfGloryBot;

import GunsOfGloryBot.AllianceDonation.Donation;
import GunsOfGloryBot.ArmyTrainer.ArmyUpgrader;
import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.CityBuilder.CastleUpgrader;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.Research;
import GunsOfGloryBot.Researcher.ResearchInitialize;
import GunsOfGloryBot.service.*;


import java.awt.*;


public class GogBotApp {


    public static void main(String[] args) throws AWTException, InterruptedException {

        BotInterface botInterface = new BotInterface();
        ScreenMovements test0 = new ScreenMovements();
        TrainArmy test = new TrainArmy();

        ResearchInitialize test2 = new ResearchInitialize();
        //test2.researchDevelop();
        MouseActions test3 = new MouseActions();
        TentMaker test4 = new TentMaker();
        AttackMonsters test5 = new AttackMonsters();
        MouseActions mouse = new MouseActions();
        botInterface.trainingInProgressTest();
        ScreenMovements test14 = new ScreenMovements();
        //botInterface.getExampleCoords();
        Farm test6 = new Farm();
        ArmyUpgrader test7 = new ArmyUpgrader();
        Research test8 = new Research();
        BuildingService test9 = new BuildingService();
        CastleUpgrader test10 = new CastleUpgrader();
        Strings test11 = new Strings();
        //test10.UpgradeCastleInit();
        //test0.previewOfLowerCityBuildings();
        Donation test12 = new Donation();
        /*System.out.println(        test11.is2ndDonationNotAvaiable()
        );
        System.out.println(        test11.is3rdDonationNotAvaiable()
        );*/
        botInterface.appRun(); // GOGOGOGO KURWA

    }
}

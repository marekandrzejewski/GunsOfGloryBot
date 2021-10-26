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
import GunsOfGloryBot.service.BuildingService;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.ScreenMovements;


import java.awt.*;


public class GogBotApp {


    public static void main(String[] args) throws AWTException, InterruptedException {

        BotInterface botInterface = new BotInterface();
        ScreenMovements test0 = new ScreenMovements();
        TrainArmy test = new TrainArmy();
        ResearchInitialize test2 = new ResearchInitialize();
        MouseActions test3 = new MouseActions();
        TentMaker test4 = new TentMaker();
        AttackMonsters test5 = new AttackMonsters();
        MouseActions mouse = new MouseActions();
        botInterface.trainingInProgressTest();
        //botInterface.getExampleCoords();
        Farm test6 = new Farm();
        ArmyUpgrader test7 = new ArmyUpgrader();
        Research test8 = new Research();
        BuildingService test9 = new BuildingService();
        CastleUpgrader test10 = new CastleUpgrader();
        test10.UpgradeCastleInit();
        Donation test11 = new Donation();
        // test11.donationInit();
        /*System.out.println(        test11.is2ndDonationNotAvaiable()
        );
        System.out.println(        test11.is3rdDonationNotAvaiable()
        );*/
        //botInterface.appRun(); // GOGOGOGO KURWA

    }
}

package GunsOfGloryBot;

import GunsOfGloryBot.ArmyTrainer.ArmyUpgrader;
import GunsOfGloryBot.ArmyTrainer.TrainArmy;
import GunsOfGloryBot.CityBuilder.TentMaker;
import GunsOfGloryBot.Farmer.Farm;
import GunsOfGloryBot.Farmer.FarmFood;
import GunsOfGloryBot.MonsterAttacker.AttackMonsters;
import GunsOfGloryBot.Researcher.ResearchInitialize;
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
        Farm test6 = new Farm();
        ArmyUpgrader test7 = new ArmyUpgrader();


        botInterface.appRun(); // GOGOGOGO KURWA

       // test.armyTrain();            // GOTOWE





//    mouse.goToKingdomOrReturnCity();
//    test5.huntMonstersInitializer(3);
//    mouse.goToKingdomOrReturnCity();
//        test2.researchGeneral();
//        test2.researchDevelop();              //GOTOWE
        //test2.researchArmy();

//while (true){
//  test4.tentMakerInitialize(); //GOTOWE, ALE WYKRYWANIE OBRAZKA ISBUILDING SIĘ PSUŁO
//}



    }
}

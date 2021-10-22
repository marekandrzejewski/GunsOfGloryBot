package GunsOfGloryBot.Farmer;

import GunsOfGloryBot.service.MouseActions;

import java.awt.*;

public class Farm {
    FarmFood farmFood = new FarmFood();
    FarmWood farmWood = new FarmWood();
    FarmIron farmIron = new FarmIron();
    FarmSilver farmSilver = new FarmSilver();
    FarmAlliance farmAlliance = new FarmAlliance();
    MouseActions mouse = new MouseActions();

    public Farm() throws AWTException {
    }

    public void farmFood(){
        mouse.goToKingdomOrReturnCity();
        mouse.goToSearch();
        farmFood.farmInit();
    }
    public void farmWood(){
        mouse.goToKingdomOrReturnCity();
        mouse.goToSearch();
        //farmWood.farmInit();
    }
    public void farmIron(){
        mouse.goToKingdomOrReturnCity();
        mouse.goToSearch();
       // farmIron.farmInit();
    }
    public void farmSilver(){
        mouse.goToKingdomOrReturnCity();
        mouse.goToSearch();
      //  farmSilver.farmInit();
    }
}

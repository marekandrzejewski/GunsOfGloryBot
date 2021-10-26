package GunsOfGloryBot.AllianceDonation;

import GunsOfGloryBot.service.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Donation {
    MouseActions mouse = new MouseActions();
    ScreenMovements screenMovements = new ScreenMovements();
    ImageSearch imageSearch = new ImageSearch();
    Robot robot = new Robot();
    public Donation() throws AWTException {
    }

    public void donationInit(){
        mouse.moveToPointAndClick(310,572); //alliance
        mouse.moveToPointAndClick(320,416); //donations
        screenMovements.donationScrollUp();
// pick point 1
        mouse.moveToPointAndClick(220,390);
        donate();
//TODO pick point 2

//TODO pick point 3


        // TODO screenMovements.donationScrollDownToSkip3Donations();
    }

    private void donate() {
        for (int i = 0; i < 20; i++){       //TODO ILE KLIKÓW MAKSYMALNIE???!!!
            if (!is3rdDonationNotAvaiable()){
                mouse.moveToPointAndClick(340,522); //donation3
                checkIfNotEnoughResourcesAndDealWithIt();
            }
            else if (!is2ndDonationNotAvaiable()){
                mouse.moveToPointAndClick(230,522); //donation2
                if (isNotEnoughResources()){
                    checkIfNotEnoughResourcesAndDealWithIt();
                }
            }
            else {
                mouse.moveToPointAndClick(100,522); //donation1
                if (isNotEnoughResources()){
                    checkIfNotEnoughResourcesAndDealWithIt();
                }
            }
        }
    }

    private void checkIfNotEnoughResourcesAndDealWithIt() { // TODO DONT SPEND GOLD FOR DONATE, ONLY RSS
        if (isNotEnoughResources()){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(notEnoughResources))[0],
                    (imageSearch.imageLocation(notEnoughResources))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
            if (areAvaiableInventoryResources1k()){
                CoordData coordData2 = new CoordData(
                        (imageSearch.imageLocation(getResourcesFromInventory1k))[0],
                        (imageSearch.imageLocation(getResourcesFromInventory1k))[1]
                );
                mouse.moveToPointAndClick(coordData2.getCoordX(), coordData2.getCoordY());
                mouse.moveToPointAndClick(300,446); // move to number bar and click
                for (int j = 0; j < 3; j++) {
                    robot.keyPress(KeyEvent.VK_9);      // type all resources avaiable
                    robot.keyRelease(KeyEvent.VK_9);
                }
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);    //accept
                mouse.moveToPointAndClick(225,485); //use
                mouse.moveToPointAndClick(403,325); //close
                donate();   //try again

            }
        }
    }

    String donation2 = "C:\\Users\\Admin\\Desktop\\goggraphics\\donation2.png";
    String donation3 = "C:\\Users\\Admin\\Desktop\\goggraphics\\donation3.png";
    String notEnoughResources = "C:\\Users\\Admin\\Desktop\\goggraphics\\notenoughresources.png";
    String getResourcesFromInventory1k = "C:\\Users\\Admin\\Desktop\\goggraphics\\getResourcesFromInventory.png";

    public boolean is2ndDonationNotAvaiable() {return ImageOnScreen.isOnScreen(donation2);}
    public boolean is3rdDonationNotAvaiable() {return ImageOnScreen.isOnScreen(donation3);}
    public boolean isNotEnoughResources() {return ImageOnScreen.isOnScreen(notEnoughResources);}
    public boolean areAvaiableInventoryResources1k() {return ImageOnScreen.isOnScreen(getResourcesFromInventory1k);}


}

package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.service.*;

import java.awt.*;

public class Research {
    MouseActions mouse = new MouseActions();
    ScreenMovements screenMovements = new ScreenMovements();
    Strings strings = new Strings();

    public Research() throws AWTException {
    }

    public void goToAcademyAndResearch() throws AWTException {
        if (ImageOnScreen.isOnScreen(Strings.mapa)){
            mouse.goToKingdomOrReturnCity();            // if we are out of city
        }
        if (!strings.checkIfAcademyIsVisibleOnScreen()) {
            screenMovements.previewOfLowerCityBuildings();
        } else toTheAcademyAndClickResearch();
        toTheAcademyAndClickResearch();
    }

    private void toTheAcademyAndClickResearch() {
        mouse.moveToPointAndClick(1032,506);
        mouse.moveToPointAndClick(1073,443); //klik badania
    }

    public void pickGeneralCategory(){
       mouse.moveToPointAndClick(686,288);
    }
    public void pickDevelopCategory(){
        mouse.moveToPointAndClick(808,288);
    }
    public void pickFightCategory(){
        mouse.moveToPointAndClick(686,464);
    }
    public void pickDefenseCategory(){
        mouse.moveToPointAndClick(922,288);
    }
    public void pickCreationCategory(){
        mouse.moveToPointAndClick(1044,288);
    }

}



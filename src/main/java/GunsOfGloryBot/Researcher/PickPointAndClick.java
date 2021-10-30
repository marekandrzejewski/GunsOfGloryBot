package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.service.*;

import java.awt.*;

public class PickPointAndClick {
    boolean isInitialized = false;
    Strings strings = new Strings();
    ImageSearch imageSearch = new ImageSearch();
    ScreenMovements screenMovements = new ScreenMovements();
    MouseActions mouse = new MouseActions();

    int baseX = 300;
    int baseY = 255;
    int accidentCounter = 0;

    public PickPointAndClick() throws AWTException {
    }
    // TOP FIRST 300,255   x+170 to next
    // MIDDLE FIRST 300, 345 y+120 to next
    // BOTTOM FIRST 300, 435

    public void initializeResearch(){
        CoordData coordData = new CoordData(
                (imageSearch.imageLocation(strings.researching))[0],
                (imageSearch.imageLocation(strings.researching))[1]
        );
        mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        mouse.closeAcademyScreen();
    }

    public void pickTopAndClick(){
        if (baseX > 1000) {
            baseX = 300;
            screenMovements.academyMoveRight();
        }
        mouse.moveToPointAndClick(baseX,baseY);//top

        if (strings.checkIfResearchAvaiable() || accidentCounter > 20){
            baseX = 300;
            accidentCounter = 0;
           initializeResearch();
           isInitialized = true;
           //order list. next order
        }
        else {
            mouse.closeResearchInnerScreen();
            accidentCounter++;
            pickMiddleAndClick();
        }
    }
    public void pickMiddleAndClick(){

        //pick a point and click
        mouse.moveToPointAndClick(baseX,baseY + 120); // middle
        if (strings.checkIfResearchAvaiable()){
            baseX = 300;
            accidentCounter = 0;
            initializeResearch();
            isInitialized = true;

        }
        else {
            mouse.closeResearchInnerScreen();
            accidentCounter++;
            pickBottomAndClick();
        }
    }

    public void pickBottomAndClick(){

        //pick a point and click
        mouse.moveToPointAndClick(baseX, baseY + 120);

        if (strings.checkIfResearchAvaiable()){
            baseX = 300;
            accidentCounter = 0;
            initializeResearch();
            isInitialized = true;
        }
        else {
            baseX = baseX + 170;
            mouse.closeResearchInnerScreen();
            accidentCounter++;
            pickTopAndClick();
        }

    }


}

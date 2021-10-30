package GunsOfGloryBot.service;

import GunsOfGloryBot.MonsterAttacker.AttackMonsters;

import java.awt.*;

public class Strings {

    ImageSearch imageSearch = new ImageSearch();
    MouseActions mouse = new MouseActions();

    public static int marches;

    public static String mapa = "C:\\Users\\Admin\\Desktop\\goggraphics\\mapa.png";
    public static String giftCollectable = "C:\\Users\\Admin\\Desktop\\goggraphics\\giftcollectable.png";
    public static String docCollectable = "C:\\Users\\Admin\\Desktop\\goggraphics\\doccollectable.png";
    public static String trainable = "C:\\Users\\Admin\\Desktop\\goggraphics\\trainable.png";
    public String isResearching1 = "C:\\Users\\Admin\\Desktop\\goggraphics\\ifisresearching.png";
    public String fragmentAkademii = "C:\\Users\\Admin\\Desktop\\goggraphics\\fragmentakademii.png";
    public String researching = "C:\\Users\\Admin\\Desktop\\goggraphics\\researching.png";
    public String invalidTileLevel = "C:\\Users\\Admin\\Desktop\\goggraphics\\invalidtilelevel.png";
    public String march = "C:\\Users\\Admin\\Desktop\\goggraphics\\march.png";
    public String attackable = "C:\\Users\\Admin\\Desktop\\goggraphics\\attackable.png";
    public String invalidMonsterLevel = "C:\\Users\\Admin\\Desktop\\goggraphics\\invalidmonsterlevel.png";
    public String someoneAttacksTile = "C:\\Users\\Admin\\Desktop\\goggraphics\\ifsomeoneisattackingtile.png";
    public String oneArmyInMarch = "C:\\Users\\Admin\\Desktop\\goggraphics\\onearmyinmarch.png";
    public String chickInCity = "C:\\Users\\Admin\\Desktop\\goggraphics\\laskawmiescie.png";
    public String tryToResearchWhenAcademyIsBuilding = "C:\\Users\\Admin\\Desktop\\goggraphics\\close.png";
    public String closeXinAcademyScreen = "C:\\Users\\Admin\\Desktop\\goggraphics\\closexinacademyscreen.png";
    public String academyVisible = "C:\\Users\\Admin\\Desktop\\goggraphics\\visibleacademyonscreen.png";
    public String researchInitializerNotVisible1 = "C:\\Users\\Admin\\Desktop\\goggraphics\\researchingnotvisible1.png";
    public String researchInitializerNotVisible2 = "C:\\Users\\Admin\\Desktop\\goggraphics\\researchingnotvisible2.png";
    public String researchInitializerNotVisible3 = "C:\\Users\\Admin\\Desktop\\goggraphics\\researchingnotvisible3.png";
    public String reklama1badania = "C:\\Users\\Admin\\Desktop\\goggraphics\\reklamabadania.png";

    public Strings() throws AWTException {
    }

    public void checkIfTrainableAndClick(){
        if (ImageOnScreen.isOnScreen(trainable)) {
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\trainable.png"))[0],
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\trainable.png"))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
    }
    public void checkIfCollectableAndClick() {
        if (ImageOnScreen.isOnScreen(giftCollectable)) {
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\giftcollectable.png"))[0],
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\giftcollectable.png"))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
        if (ImageOnScreen.isOnScreen(docCollectable)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\doccollectable.png"))[0],
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\doccollectable.png"))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
    }
    public boolean ifResearchInAcademyIsInProgress(){
        if (ImageOnScreen.isOnScreen(isResearching1) && ImageOnScreen.isOnScreen(fragmentAkademii)) {
            System.out.println("badania się wykonują");
            mouse.closeAcademyScreen();
            return false;
        } else return !ImageOnScreen.isOnScreen(isResearching1) && ImageOnScreen.isOnScreen(fragmentAkademii);
    }
    public boolean checkIfResearchAvaiable(){
        return ImageOnScreen.isOnScreen(researching);
    }
    public boolean checkIfAcademyIsVisibleOnScreen(){
        return ImageOnScreen.isOnScreen(academyVisible);
    }
       public boolean isTileInvalid(){
        return ImageOnScreen.isOnScreen(invalidTileLevel);
    }
    public boolean isInCityScreen(){
        return ImageOnScreen.isOnScreen(chickInCity);
    }
    public boolean isArmyMarching(){
        return ImageOnScreen.isOnScreen(oneArmyInMarch);
    }
    public void checkIfMarchAvaiableAndClick() throws AWTException {

        if (ImageOnScreen.isOnScreen(march)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(march))[0],
                    (imageSearch.imageLocation(march))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());

        }else if (!ImageOnScreen.isOnScreen(march)){
            {
                AttackMonsters.i--;
                System.out.println("niewidoczny marsz, cofamy licznik o jeden");
                mouse.closeAcademyScreen();
            }
        }
        else if (ImageOnScreen.isOnScreen(someoneAttacksTile)){
            mouse.closeAcademyScreen();
            mouse.closeAcademyScreen();
        }
        else if (isLevelInvalid()) {
            AttackMonsters attackMonsters = new AttackMonsters();
            attackMonsters.attackMonsters();
        }
        else mouse.closeAcademyScreen();
    }
    public void checkIfAttackableAndClickAttack(){
        if (ImageOnScreen.isOnScreen(attackable)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(attackable))[0],
                    (imageSearch.imageLocation(attackable))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
        else mouse.closeAcademyScreen();
    }
    public void checkIfAcademyIsBuildingWhileTryToResearch(){
        if (ImageOnScreen.isOnScreen(tryToResearchWhenAcademyIsBuilding)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(tryToResearchWhenAcademyIsBuilding))[0],
                    (imageSearch.imageLocation(tryToResearchWhenAcademyIsBuilding))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
    }
    public boolean isLevelInvalid(){
        return ImageOnScreen.isOnScreen(invalidMonsterLevel);
    }

    public void checkIfCloseXisAvaiableAndClick() {
        if (ImageOnScreen.isOnScreen(closeXinAcademyScreen)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(closeXinAcademyScreen))[0],
                    (imageSearch.imageLocation(closeXinAcademyScreen))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
    }
    public void ifResearchingNotVisibleCloseAndMoveNext(){
        if (ImageOnScreen.isOnScreen(researchInitializerNotVisible1)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(researchInitializerNotVisible1))[0],
                    (imageSearch.imageLocation(researchInitializerNotVisible1))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
        if (ImageOnScreen.isOnScreen(researchInitializerNotVisible2)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(researchInitializerNotVisible2))[0],
                    (imageSearch.imageLocation(researchInitializerNotVisible2))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
        if (ImageOnScreen.isOnScreen(researchInitializerNotVisible3)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(researchInitializerNotVisible3)[0]),
                    (imageSearch.imageLocation(researchInitializerNotVisible3)[1])
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }

    }

    public void checkIfAdIsVisibleAndCloseIt() {
        if (ImageOnScreen.isOnScreen(reklama1badania)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(reklama1badania))[0],
                    (imageSearch.imageLocation(reklama1badania))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
        }
    }
}

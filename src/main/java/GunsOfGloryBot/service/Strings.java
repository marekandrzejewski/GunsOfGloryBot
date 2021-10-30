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
        }
        return !ImageOnScreen.isOnScreen(isResearching1) && ImageOnScreen.isOnScreen(fragmentAkademii);
    }
    public boolean checkIfResearchAvaiable(){
        return ImageOnScreen.isOnScreen(researching);
    }
    public boolean isTileInvalid(){
        return ImageOnScreen.isOnScreen(invalidTileLevel);
    }
    public boolean isArmyMarching(){
        return ImageOnScreen.isOnScreen(oneArmyInMarch);
    }
    public void checkIfMarchAvaiableAndClick() throws AWTException {
        marches = 0;
        if (ImageOnScreen.isOnScreen(march)){
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation(march))[0],
                    (imageSearch.imageLocation(march))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
            marches++;
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
    public boolean isLevelInvalid(){
        return ImageOnScreen.isOnScreen(invalidMonsterLevel);
    }
}

package GunsOfGloryBot.MonsterAttacker;

import GunsOfGloryBot.service.ImageOnScreen;
import GunsOfGloryBot.service.MouseActions;

import java.awt.*;

public class AttackMonsters {

    //TODO GOTOWE ALE ZROBIONE NA 1 SLOT MARSZU, ZRÓB NA WIĘCEJ
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    String invalidMonsterLevel = "C:\\Users\\Admin\\Desktop\\goggraphics\\invalidmonsterlevel.png";


    public AttackMonsters() throws AWTException {
    }
    public boolean isLevelInvalid(){
        return ImageOnScreen.isOnScreen(invalidMonsterLevel);
    }
    public void huntMonstersInitializer(int level){
        mouse.goToSearch();
        robot.mouseMove(80,557); // click threats
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        setMonsterLevelAndSearchIt(level);
        attackMonsters();
    }
    public void attackMonsters(){
        robot.mouseMove(223,426); //click middle screen on monster
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(402,482); //click attack
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        if (isLevelInvalid()){
            lowerLevelByOneAndTryAgain();

        } else {
            robot.mouseMove(360,530); //click march
            robot.delay(2000);
            mouse.click();
            robot.delay(2000);
        }

    }
    public void setMonsterLevelAndSearchIt(int level){
        robot.delay(2000);
        robot.mouseMove(132,466); // click +
        robot.delay(2000);
        for (int i = 1; i <= level ; i++){
            mouse.click();
            robot.delay(2000);
        }
       mouse.clickSearchInKingdomScreen();
    }



    private void lowerLevelByOneAndTryAgain() {
        robot.mouseMove(29,468); //click - , lower level by one
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        mouse.clickSearchInKingdomScreen();
        attackMonsters(); //try again
    }
}

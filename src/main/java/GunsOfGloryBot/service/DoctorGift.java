package GunsOfGloryBot.service;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DoctorGift {
    ScreenMovements screenMovements = new ScreenMovements();

    public DoctorGift() throws AWTException {
    }

    public void getDoctorGiftInCase() throws AWTException {
        MouseActions mouse = new MouseActions();
        Strings strings = new Strings();
        mouse.moveToPointAndClick(255,400);
        mouse.moveToPointAndClick(255,400);
        screenMovements.dragAndDropUpLeftMenu();
        mouse.moveToPointAndClick(562,265); //click get gift
        strings.checkIfCollectableAndClick();
        strings.checkIfCollectableAndClick();   // doc OR gift !!!

       /* robot.mouseMove(205,461); //or exit if no gift
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);*/ //TODO unnecessary??!!

    }
}

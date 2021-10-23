package GunsOfGloryBot.Researcher;

import GunsOfGloryBot.BotInterface;
import GunsOfGloryBot.service.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Research {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    ScreenMovements screenMovements = new ScreenMovements();
    String fragmentAkademii = "C:\\Users\\Admin\\Desktop\\goggraphics\\fragmentakademii.png";

    public Research() throws AWTException {
    }

    public void goToAcademyAndResearch() throws AWTException {
        robot.delay(2000);
        robot.mouseMove(6,436);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        screenMovements.dragAndDropDownLeftMenu();
        robot.delay(2000);
        //wymierz w punkt 1
        robot.delay(2000);
        robot.mouseMove(161,386); // jeśli brak nagrody dnia i brak astrologa
        robot.delay(2000);
        mouse.click();
        toTheMiddleScreenAndClickResearchOnAcademy();

        if (!ImageOnScreen.isOnScreen(fragmentAkademii)){// jeśli nie weszłem do akademii
            robot.delay(2000);
            robot.mouseMove(6,436); //wywołaj jeszcze raz menu żeby za drugim razem trafić
            robot.delay(2000);
            mouse.click();
            robot.delay(2000);
            screenMovements.dragAndDropDownLeftMenu();
            robot.delay(2000);
            //wymierz w punkt 2
            robot.delay(2000);
            robot.mouseMove(161,368); // jeśli są nagrody dnia ale nie ma astrologa
            robot.delay(2000);
            mouse.click();
            //na środek ekranu i klik
            toTheMiddleScreenAndClickResearchOnAcademy();
        }
        if (!ImageOnScreen.isOnScreen(fragmentAkademii)){// jeśli nie weszłem do akademii
            robot.delay(2000);
            robot.mouseMove(6,436); //wywołaj jeszcze raz menu żeby za trzecim razem trafić
            robot.delay(2000);
            mouse.click();
            robot.delay(2000);
            screenMovements.dragAndDropDownLeftMenu();
            robot.delay(2000);
            //wymierz w punkt 3
            robot.delay(2000);
            robot.mouseMove(161,349); // jeśli są nagrody dnia i jest astrolog
            robot.delay(2000);
            mouse.click();
            //na środek ekranu i klik
            toTheMiddleScreenAndClickResearchOnAcademy();
        }
    }

    private void toTheMiddleScreenAndClickResearchOnAcademy() {
        //na środek ekranu i klik
        robot.delay(2000);
        robot.mouseMove(218,415);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
        robot.mouseMove(262,451); //klik badania
        robot.delay(2000);
        mouse.click();
    }

    public void pickGeneralCategory(){
        robot.mouseMove(230,379);
        robot.delay(2500);
        mouse.click();
        robot.delay(2000);
    }
    public void pickDevelopCategory(){
        robot.mouseMove(286,379);
        robot.delay(2500);
        mouse.click();
        robot.delay(2000);
    }
    public void pickFightCategory(){
        robot.mouseMove(230,471);
        robot.delay(2500);
        mouse.click();
        robot.delay(2000);
    }

}



package GunsOfGloryBot.CityBuilder;

import GunsOfGloryBot.service.BuildingService;
import GunsOfGloryBot.service.MouseActions;
import GunsOfGloryBot.service.ScreenMovements;

import java.awt.*;
import java.awt.event.InputEvent;

public class CastleUpgrader { // upgrades either castle or components, function terminates after building one component
    ScreenMovements screenMovements = new ScreenMovements();
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    TentMaker tentMaker = new TentMaker();
    BuildingService buildingService = new BuildingService();

    public CastleUpgrader() throws AWTException {
    }

    public void UpgradeCastleInit(){
        screenMovements.previewOfLowerCityBuildings();

        // move a bit up
        moveALittleUp();

        mouse.moveToPointAndClick(256,345); //click castle
        mouse.moveToPointAndClick(220,368); //click upgrade
        buildingService.build();
    }

    private void moveALittleUp() {
        robot.delay(2000);
        robot.mouseMove(220, 440);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseMove(310, 370);
        robot.delay(2000);
        robot.mouseMove(220, 440);
        robot.delay(3000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
    }


}

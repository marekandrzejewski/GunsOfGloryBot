package GunsOfGloryBot.service;

import java.awt.*;

public class BuildingService {
    Robot robot = new Robot();
    MouseActions mouse = new MouseActions();
    ImageSearch imageSearch = new ImageSearch();
    String buildable = "C:\\Users\\Admin\\Desktop\\goggraphics\\buildable.png";
    String buildInProgress = "C:\\Users\\Admin\\Desktop\\goggraphics\\buildinprogress.png";
    String start1 = "C:\\Users\\Admin\\Desktop\\goggraphics\\start1.png";
    String start2 = "C:\\Users\\Admin\\Desktop\\goggraphics\\start2.png";

    public BuildingService() throws AWTException {
    }

    public boolean isBuildable() {
        return ImageOnScreen.isOnScreen(buildable);
    }

    public boolean isBothBuildersBusy() {
        return ImageOnScreen.isOnScreen(buildInProgress);
    }

    public boolean isOneBuildingRequired() {
        return ImageOnScreen.isOnScreen(start1);
    }

    public boolean areTwoBuildingRequired() {
        return ImageOnScreen.isOnScreen(start2);
    }


    public void build() {
        checkIfBuildableAndBuild();
            checkIfComponentIsRequiredAndTryToBuildIt();


        if (areTwoBuildingRequired()) {
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\start2.png"))[0],
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\start2.png"))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
            checkIfBuildableAndBuild();
            if (isBothBuildersBusy()) {
                closeBuildingScreenAndExitToCity();
            }
        }
        if (isBothBuildersBusy()) {
            closeBuildingScreenAndExitToCity();
        }
    }

    public void checkIfBuildableAndBuild() {
        if (isBuildable()) {
            robot.mouseMove(385, 528);
            robot.delay(2000);
            mouse.click();      //build
            robot.delay(2000);
        }
        else {
            checkIfComponentIsRequiredAndTryToBuildIt();
        }
    }

    public void closeBuildingScreenAndExitToCity() {
        robot.mouseMove(376, 327);
        robot.delay(2000);
        mouse.click();      //close and exit
        robot.delay(2000);
        robot.mouseMove(428, 275);
        robot.delay(2000);
        mouse.click();
        robot.delay(2000);
    }

    public void checkIfComponentIsRequiredAndTryToBuildIt() {
        if (isOneBuildingRequired()) {
            CoordData coordData = new CoordData(
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\start1.png"))[0],
                    (imageSearch.imageLocation("C:\\Users\\Admin\\Desktop\\goggraphics\\start1.png"))[1]
            );
            mouse.moveToPointAndClick(coordData.getCoordX(), coordData.getCoordY());
            checkIfBuildableAndBuild();
            if (isBothBuildersBusy()) {
                closeBuildingScreenAndExitToCity();
            }
        }
    }
}

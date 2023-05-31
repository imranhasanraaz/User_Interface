package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class RobotUtils {
    private final ISettingsFile settingsFile = new JsonSettingsFile("settings.json");

    public void uploadFile(String path ) {
        try {
            Robot robot = new Robot();
            String filePath = new File(path).getAbsolutePath();
            StringSelection filepath = new StringSelection(filePath);
            int delay = Integer.parseInt(settingsFile.getValue("/delayTime").toString());
            robot.delay(delay);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
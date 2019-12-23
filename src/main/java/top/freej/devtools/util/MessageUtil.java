package top.freej.devtools.util;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * @author jinfanx
 * @ClassName MessageUtil
 * @Description
 * @Date 2019-12-21
 */
public class MessageUtil {
    public static void info(Alert.AlertType type, String message) {
        Platform.runLater(() -> new Alert(type, message, null).show());
    }
}
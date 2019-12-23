package top.freej.devtools.util;

import javafx.scene.control.Alert;

/**
 * @author jinfanx
 * @ClassName ValidateUtil
 * @Description
 * @Date 2019-12-21
 */
public class ValidateUtil {
    public static boolean alertNotNull(Object value, String message) {
        if (value == null) {
            MessageUtil.info(Alert.AlertType.ERROR, message);
            return false;
        }
        return true;
    }
}
